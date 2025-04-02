from sim import simulation
from graficas import generar_graficas
if __name__ == "__main__":
    return_str = f"""
    ******************************
    SALA DE EMERGENCIAS
    ******************************
    CANTIDAD DE DOCTORES: {6}
    CANTIDAD DE ENFERMEROS: {5}
    CANTIDAD DE LABORATORISTAS {2}
    CANTIDAD DE RADIOLOGOS {1}
    
    TIEMPO DE ATENCION: {24*60}
    ******************************
    PACIENTES

    """

    pacientes = simulation()

    for paciente in pacientes:
        return_str += f'\n{paciente.name} {paciente.id} PRIORIDAD: {paciente.prioridad}- {paciente.tiempo_espera['total']} min - Q {paciente.costos}'
    
    print(return_str)

    generar_graficas(pacientes)


