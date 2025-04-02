import simpy
import random
from Paciente import Paciente

random.seed(10)

class Emergencias:
    def __init__(
            self, 
            env, 
            doctores, 
            enfermeros, 
            rayosx, 
            lab,
            pacientes: list
        ):
        self.env = env
        
        # recursos con prioridad
        self.doctores = doctores
        self.enfermeros = enfermeros
        self.rayosx = rayosx
        self.lab = lab
        
        self.pacientes = pacientes
        self.tiempos_espera = {
            'atencion': [],
            'doctor': [],
            'lab': [],
            'rayosx': [],
            'total': []
        }
        
        # Costos por recursos
        self.costos = {
            'doctor': (15_000) / ((24*60)/6), # salario de 15k cada 10 mins por paciente
            'enfermero': (4_500) / ((24*60)/6), # salario de 4.5k cada 10 mins por paciente
            'rayosx': 200,
            'lab': 200
        }
    
    def __tiempos(self, prioridad):
        tiempos = {
            'atencion': 10 - prioridad,
            'doctor': 15 + (5 - prioridad) * 10,
            'lab': 30,
            'rayosx': 20
        }
        return tiempos
    
    def __lab_aleatorio(self, prioridad):
        return random.random() < (0.6 + (5 - prioridad) * 0.1)
    
    def __rayosx_aleatorios(self, prioridad):
        rayosx = {
            1: 0.7,
            2: 0.6,
            3: 0.5,
            4: 0.3,
            5: 0.1
        }
        return random.random() < rayosx[prioridad]

    def run(self, paciente: Paciente):
        tiempo_entrada = self.env.now
        paciente.tiempo_entrada = tiempo_entrada

        # 1) atencion inicial del enfermero
        inicio_atencion = self.env.now
        
        with self.enfermeros.request(priority=1) as req:
            yield req
            paciente.sumar_costo(self.costos['enfermero'])
            paciente.tiempo_espera['atencion'] = self.env.now - inicio_atencion
            self.tiempos_espera['atencion'].append(paciente.tiempo_espera['atencion'])
            
            tiempo_atencion = self.__tiempos(paciente.prioridad)['atencion']
            yield self.env.timeout(tiempo_atencion)
        
        # 2) atencion del doctor
        inicio_doctor = self.env.now
        
        with self.doctores.request(priority=paciente.prioridad) as req:
            yield req
            
            paciente.sumar_costo(self.costos['doctor'])
            paciente.tiempo_espera['doctor'] = self.env.now - inicio_doctor
            self.tiempos_espera['doctor'].append(paciente.tiempo_espera['doctor'])
            
            # diagnóstico del doctor
            tiempo_doctor = self.__tiempos(paciente.prioridad)['doctor']
            yield self.env.timeout(tiempo_doctor)
        
        # 3) pruebas de laboratorio
        if self.__lab_aleatorio(paciente.prioridad):
            inicio_lab = self.env.now
            
            with self.lab.request(priority=paciente.prioridad) as req:
                yield req
                paciente.sumar_costo(self.costos['lab'])
                paciente.tiempo_espera['lab'] = self.env.now - inicio_lab
                self.tiempos_espera['lab'].append(paciente.tiempo_espera['lab'])
                
                # tiempo prueba lab
                tiempo_lab = self.__tiempos(paciente.prioridad)['lab']
                yield self.env.timeout(tiempo_lab)
        
        # 4) pruebas de rayos X
        if self.__rayosx_aleatorios(paciente.prioridad):
            inicio_rayosx = self.env.now
            
            with self.rayosx.request(priority=paciente.prioridad) as req:
                yield req
                paciente.sumar_costo(self.costos['rayosx'])
                paciente.tiempo_espera['rayosx'] = self.env.now - inicio_rayosx
                self.tiempos_espera['rayosx'].append(paciente.tiempo_espera['rayosx'])
                
                # tiempo rayos x
                tiempo_rayosx = self.__tiempos(paciente.prioridad)['rayosx']
                yield self.env.timeout(tiempo_rayosx)
        
        paciente.tiempo_salida = self.env.now
        paciente.tiempo_espera['total'] = paciente.tiempo_salida - paciente.tiempo_entrada
        
        # registro
        self.tiempos_espera['total'].append(paciente.tiempo_espera['total'])
        self.pacientes.append(paciente)