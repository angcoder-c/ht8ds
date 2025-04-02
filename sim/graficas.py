import matplotlib.pyplot as plt
import numpy as np
from sim import simulation

def generar_graficas(pacientes):
    prioridades = [
        paciente.prioridad 
        for paciente in pacientes
    ]
    tiempos_espera = [
        paciente.tiempo_salida - paciente.tiempo_entrada 
        for paciente in pacientes
    ]
    costos = [
        paciente.costos 
        for paciente in pacientes
    ]

    # diagrama de caja y bigotes, 
    # tiempo de espera por prioridad
    data_tiempo = []

    for i in range(1, 6):
        tiempos_filtrados = []
        for p, t in zip(prioridades, tiempos_espera):
            if p == i:
                tiempos_filtrados.append(t)
        data_tiempo.append(tiempos_filtrados)

    plt.boxplot(data_tiempo, labels=[1, 2, 3, 4, 5])
    plt.xlabel("Prioridad (1=alta, 5=baja)")
    plt.ylabel("Tiempo de espera")
    plt.title("Tiempo de espera VS Prioridad")
    plt.grid(True)
    plt.show()

    # grafica de barras de costo por prioridad
    prioridad_unica = sorted(set(prioridades))
    costo_promedio = []

    for i in prioridad_unica:
        costos_filtrados = []
        for p, c in zip(prioridades, costos):
            if p == i:
                costos_filtrados.append(c)
        costo_promedio.append(np.mean(costos_filtrados))


    plt.bar(prioridad_unica, costo_promedio, color='orange', alpha=0.7)
    plt.xlabel("Prioridad (1=Alta, 5=Baja)")
    plt.ylabel("Costo")
    plt.title("Costo VS Prioridad")
    plt.xticks(prioridad_unica)
    plt.grid(axis='y', linestyle='--', alpha=0.7)
    plt.show()