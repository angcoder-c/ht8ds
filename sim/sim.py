from simpy import PriorityResource, Environment
from Paciente import Paciente
from Emergencias import Emergencias
import random

random.seed(10)

def pacientes_factory(env, emergencias, tiempo_simulacion):
    id_counter = 0
    
    while env.now < tiempo_simulacion:
        id_counter += 1
        paciente = Paciente(
            name=f'Paciente {id_counter}',
            prioridad=random.randint(1, 5),
            id=id_counter,
            tiempo_entrada=env.now
        )
        
        env.process(emergencias.run(paciente))
        # se crea un paciente cada 10 minutos
        yield env.timeout(random.expovariate(1/10))

def simulation():
    n_doctores = 3
    n_enfermeros = 5
    n_laboratoristas = 2
    n_radiologos = 1
    tiempo_simulacion = 24 * 60
    pacientes = []

    env = Environment()
    doctores = PriorityResource(env=env, capacity=n_doctores)
    enfermeros = PriorityResource(env=env, capacity=n_enfermeros)
    lab = PriorityResource(env=env, capacity=n_laboratoristas)
    rayosx = PriorityResource(env=env, capacity=n_radiologos)

    emergencias = Emergencias(env, doctores, enfermeros, lab, rayosx, pacientes)
    
    env.process(pacientes_factory(env, emergencias, tiempo_simulacion))
    env.run(until=tiempo_simulacion)
    return pacientes
