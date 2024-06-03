# CLI-myNotesApp
Una aplicación de gestión de tareas utilizando MapDB.

## Requisitos
- Java 8 o superior
- Maven

## Instrucciones para Ejecutar
1. Clonar el repositorio
2. Navega al directorio del proyecto:cd my-notes-app
3. Compila el proyecto: mvn clean install
4. Ejecuta la aplicación:mvn exec
-Dexec.mainClass="com.example.myNotesApp.main"


## Instrucciones para Ejecutar las Pruebas
1. Ejecuta las pruebas: mvn test


## Estructura del Proyecto
- `com.example.config`: Configuración de la base de datos.
- `com.example.model`: Clases del modelo.
- `com.example.service`: Interfaces y clases de servicio.
- `com.example.util`: Utilidades.
- `com.example.MyNotesAppApplication`: Clase principal para ejecutar la aplicación.
- `src/test/java`: Pruebas unitarias.


## Scripts para la Configuración del Proyecto
Asegurarse de tener Maven instalado y configurado en la máquina. Los comandos clave son:
- Compilar el proyecto: mvn clean install
- Ejecutar la aplicación: mvn exec:java -Dexec.mainClass="com.example.myNotesApp"
- Ejecutar las pruebas: mvn test

- Rezar a jesusito :D
