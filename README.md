# Hospital Nurse Application

## Descripción

Este proyecto es una aplicación backend desarrollada con Spring Boot y Hibernate, diseñada para gestionar la información de enfermeros en un entorno hospitalario. Permite realizar operaciones CRUD (Crear, Leer, Actualizar y Borrar) sobre los datos de los enfermeros, así como realizar autenticación básica mediante un sistema de login. Este proyecto se conecta a una base de datos SQL gestionada con phpMyAdmin para el almacenamiento de los datos.

## Tecnologías utilizadas
- **Java**: Lenguaje de programación.
- **Spring Boot**: Framework principal para la creación de la API REST.
- **Hibernate**: Framework de mapeo objeto-relacional (ORM) para gestionar la base de datos.
- **phpMyAdmin**: Sistema de gestión de base de datos.
- **Maven**: Herramienta de gestión de dependencias.

## Instalación

### 1. Clonar el repositorio en la IDE
Para este proyecto se ha utilizado la IDE de Eclipse, pero es válida cualquier otra.
   - Abre Eclipse y selecciona `File > Import > Git > Projects from Git > Clone URI`.
   - Ingresa la URL del repositorio de GitHub:
     ```plaintext
     https://github.com/SergioArenas98/SpringBoot_Project.git
     ```
   - Presiona `Next`, selecciona la rama principal (`main` o `master`) y haz clic en `Finish`.
   - Luego, Eclipse descargará el proyecto y lo importará automáticamente.

### 2. Configuración de base de datos en phpMyAdmin
   - Accede a phpMyAdmin y crea una nueva base de datos para el proyecto.
   - Configura el archivo `application.properties` en el directorio `src/main/resources` con los detalles de conexión a la base de datos:
     ```properties
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql: true
     spring.datasource.url = jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7742899?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
     spring.datasource.username=sql7742899
     spring.datasource.password=BJrKMayFZa
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     ```

### 3. Instalación de dependencias
   Eclipse gestionará las dependencias automáticamente si tienes Maven configurado. De lo contrario, haz clic derecho en el proyecto, selecciona `Maven > Update Project` para descargar todas las dependencias necesarias.

### 4. Ejecutar la aplicación
   Para ejecutar la aplicación:
   - Haz clic derecho en el proyecto y selecciona `Run As > Spring Boot App`.

---

## Uso

La API proporciona varias funcionalidades para interactuar con los recursos de enfermeros. A continuación se detallan los endpoints principales.

### Endpoints de la API 

#### **Obtener todos los enfermeros**
- **URL:** `GET /nurse/index`
- **Descripción:** Devuelve una lista de todos los enfermeros registrados en el sistema.
- **Respuesta de ejemplo:**
    ```json
    [
      {
        "nurseId": 1,
        "name": "Laura",
        "user": "laura_23",
        "password": "password123"
      },
      {
        "nurseId": 2,
        "name": "Juan",
        "user": "juan_99",
        "password": "pass456"
      }
    ]
    ```

---

#### **Iniciar sesión**
- **URL:** `POST /nurse/login`
- **Descripción:** Autentica a un enfermero con su nombre de usuario y contraseña.
- **Cuerpo de la solicitud:**
    ```json
    {
      "user": "laura_23",
      "password": "password123"
    }
    ```
- **Respuesta de ejemplo:**
  - **200 OK** (Credenciales correctas): `true`
  - **401 Unauthorized** (Credenciales incorrectas): `false`

---

#### **Buscar enfermero por nombre**
- **URL:** `GET /nurse/name/{name}`
- **Descripción:** Busca un enfermero por su nombre.
- **Parámetro de ruta:** `name` - El nombre del enfermero que se desea buscar.
- **Respuesta de ejemplo:**
  ```json
  {
    "nurseId": 1,
    "name": "Laura",
    "user": "laura_23",
    "password": "password123"
  }

---

#### **Buscar enfermero por ID**
- **URL:** GET /nurse/{nurseId}
- **Descripción:** Obtiene la información de un enfermero mediante su ID.
- **Parámetro de ruta:** nurseId - ID del enfermero.
- **Respuesta de ejemplo:**
  ```json
  {
    "nurseId": 1,
    "name": "Laura",
    "user": "laura_23",
    "password": "password123"
  }

---

#### **Actualizar datos de un enfermero**
- **URL:** POST /nurse/update/{nurseId}
- **Descripción:** Actualiza los datos de un enfermero existente. Solo se actualizan los campos proporcionados.
- **Parámetro de ruta:** nurseId - ID del enfermero.
- **Respuesta de ejemplo:** 
  
  ```json
  {
  "nurseId": 1,
  "name": "Laura G.",
  "user": "laura_updated",
  "password": "newpassword123"
  }

  
