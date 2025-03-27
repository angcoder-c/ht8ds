import random

random.seed(10)

class Emergencias:
    def __init__(self, env, lista, paciente, doctores, enfermeros, rayosx, laboratorio):
        self.env = env
        self.lista=lista

        # nuevo paciente
        self.paciente=paciente
        
        # recursos
        self.doctores=doctores
        self.enfermeros=enfermeros

        # containers
        self.rayosx=rayosx
        self.laboratorio=laboratorio

        self.start_time = env.now