class Paciente:
    def __init__(self, name, prioridad, id, tiempo_entrada):
        self.name = name
        self.id = id
        self.tiempo_entrada = tiempo_entrada
        self.prioridad = prioridad
        self.tiempo_salida = None
        self.tiempo_espera = {
            'atencion': 0,
            'doctor': 0,
            'lab': 0,
            'rayosx': 0,
            'total': 0
        }
        self.costos = 0

    def sumar_costo (self, costo):
        self.costos += costo