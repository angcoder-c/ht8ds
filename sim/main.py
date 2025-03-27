import simpy
from Emergencias import Emergencias

def simulation(pacientes):
    env = simpy.Environment()
    rayosx = simpy.Container(env, init=6, capacity=6)
    laboratorio = simpy.Container(env, init=6, capacity=6)
    doctores = simpy.Resource(env, capacity=1)
    enfermeros= simpy.Resource(env, capacity=1)
    tiempos = {}