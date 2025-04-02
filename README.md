# Hoja de Trabajo #8

## Instalación

```bash
git clone git@github.com:angcoder-c/ht8ds.git
cd ./ht8ds
```

### Virtualenv 

```bash
python -m pip install virtualenv
python -m venv .venv
```

#### Activación

**PowerShell**
  ```bash
  Set-ExecutionPolicy -ExecutionPolicy Bypass -Scope Process -Force
  .\venv\Scripts\Activate.ps1
  ```

**CMD**
  ```bash
  .\venv\Scripts\activate
  ```

**Bash**
  ```bash
  source .\venv\Scripts\activate
  ```

**Dependencias**

```bash
python -m pip install -r requirements.txt
```

## Ejecución

### Dependencias

```bash
mvn install
```

### Compilación

```bash
mvn package
```

### Ejecución

- **Bash**
  ```bash
  mvn exec:java -Dexec.mainClass="com.interpreter.api.App"
  ```
- **PowerShell**
  ```bash
  mvn exec:java '-Dexec.mainClass="com.interpreter.api.App"'
  ```

### Pruebas

```bash
mvn test
```



## Parte 2: Simulación de sala de emergencias

#### **Tiempo de espera VS Prioridad**

El análisis del tiempo de espera muestra que los pacientes con mayor prioridad (1) tienen tiempos de espera más reducidos en comparación con aquellos con prioridad baja (5). Sin embargo, existen valores atípicos que sugieren que ciertos casos pueden experimentar retrasos en la atención, incluso con prioridad alta, pudiendo deberse a la cantidad de médicos o enfermeros.

![image](https://github.com/user-attachments/assets/0a50770c-0c1e-4631-a60d-f0a9e723a1df)

#### **Costo vs Prioridad**
Los costos del servicio están relacionados con la prioridad del paciente. La prioridad alta (1) presentan costos más elevados, mientras que los pacientes con prioridad baja (5) tienen costos reducidos. Esto indica que la atención prioritaria requiere más recursos como pruebas de laboratorio o rayos x.

![image](https://github.com/user-attachments/assets/422c8520-8784-4e9a-b070-5af751fe0eb0)

#### **Recursos**
- **6 doctores**
- **5 enfermeros**
- **2 laboratoristas**
- **1 radiólogo**

#### **Conclusión**

Los pacientes con mayor prioridad reciben atención más rápida pero a un costo más alto, mientras que los de menor prioridad deben esperar más tiempo pero con menores costos.




