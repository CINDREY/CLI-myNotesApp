# CLI-myNotesApp
Gestión de tareas utilizando MapDB.
My Notes CLI App es una aplicación de línea de comandos para gestionar notas utilizando Picocli. Permite crear, actualizar, eliminar y listar notas.

## Requisitos
- Java 8 o superior
- Maven 3.6.0 o superior

## Instalación
1. Clonar el repositorio:
    ```sh
    git clone https://github.com/usuario/my-notes-app.git
    ```

2. Navegar al directorio del proyecto:
    ```sh
    cd my-notes-app
    ```

3. Compilar el proyecto usando Maven:
    ```sh
    mvn clean install
    ```

## Ejecución
Para ejecutar la aplicación, usa el siguiente comando:
```sh
mvn spring-boot:run




## Estructura del Proyecto
- `com.example.cli`: línea de comandos CLI. 
- `com.example.config`: Configuración de la base de datos.
- `com.example.model`: Clases del modelo.
- `com.example.service`: Interfaces y clases de servicio.
- `com.example.util`: Utilidades.
- `com.example.MyNotesAppApplication`: Clase principal para ejecutar la aplicación.
- `src/test/java`: Pruebas unitarias.



## Comandos
- create <note_message>: Crea una nueva nota con el mensaje especificado.
- getAll: Obtiene todas las notas.
- getById <note_id>: Obtiene una nota por su ID.
- update <note_id> <new_message>: Actualiza el mensaje de la nota con el ID especificado.
- delete <note_id>: Elimina la nota con el ID especificado.
- help: Muestra los comandos disponibles.
- exit: Cierra la aplicación.


Disfruta usando My Notes CLI App y Reza a jesusito :D
