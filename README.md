# Hospital Nurse Application

## Description

This project is a backend application developed with Spring Boot and Hibernate, designed to manage nurse information in a hospital setting. It allows performing CRUD (Create, Read, Update, Delete) operations on nurse data, as well as basic authentication via a login system. This project connects to an SQL database managed with phpMyAdmin for data storage.

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Main framework for creating the REST API.
- **Hibernate**: Object-Relational Mapping (ORM) framework for managing the database.
- **phpMyAdmin**: Database management system.
- **Maven**: Dependency management tool.

## Installation

### 1. Clone the Repository in the IDE
For this project, Eclipse IDE has been used, but any other IDE is valid.
   - Open Eclipse and select `File > Import > Git > Projects from Git > Clone URI`.
   - Enter the URL of the GitHub repository:
     ```plaintext
     https://github.com/SergioArenas98/SpringBoot_Project.git
     ```
   - Press `Next`, select the main branch (`main` or `master`), and click `Finish`.
   - Then, Eclipse will download the project and import it automatically.

### 2. Configure the Database in phpMyAdmin
   - Access phpMyAdmin and create a new database for the project.
   - Configure the `application.properties` file in the `src/main/resources` directory with the database connection details:
     ```properties
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql: true
     spring.datasource.url = jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7742899?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
     spring.datasource.username=sql7742899
     spring.datasource.password=BJrKMayFZa
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     ```

### 3. Install Dependencies
   Eclipse will automatically manage dependencies if Maven is configured. Otherwise, right-click the project, select `Maven > Update Project` to download all necessary dependencies.

### 4. Run the Application
   To run the application, right-click on the main class of the project, in this case `HospitalApplication` located at `SpringBoot_Pr03\src\main\java\com\example\SpringBoot_Pr03`, and select `Run As > Java Application`.
  
---

## Usage

The API provides several functionalities to interact with nurse resources. Below are the main endpoints.

### API Endpoints

#### **Get All Nurses**
- **URL:** `GET /nurse/index`
- **Description:** Returns a list of all nurses registered in the system.
- **Example Response:**
    ```json
      {
        "nurseId": 1,
        "name": "fiorella",
        "user": "fiorella01",
        "password": "password123"
      }
    ```

---

#### **Login**
- **URL:** `POST /nurse/login`
- **Description:** Authenticates a nurse with their username and password.
- **Request Body:**
    ```json
    {
      "user": "david02",
      "password": "securepass"
    }
    ```
- **Example Response:**
  - **200 OK** (Correct credentials): `true`
  - **401 Unauthorized** (Incorrect credentials): `false`

---

#### **Search Nurse by Name**
- **URL:** `GET /nurse/name/{name}`
- **Description:** Searches for a nurse by their name.
- **Path Parameter:** `name` - The name of the nurse you want to search for.
- **Example Response:**
  ```json
  {
    "nurseId": 3,
    "name": "sergio",
    "user": "sergio03",
    "password": "passw0rd"
  }
  ```

---

#### **Search Nurse by ID**
- **URL:** `GET /nurse/{nurseId}`
- **Description:** Retrieves information for a nurse by their ID.
- **Path Parameter:** `nurseId` - The ID of the nurse.
- **Example Response:**
  ```json
  {
    "nurseId": 4,
    "name": "martina",
    "user": "martina04",
    "password": "m@rt!na123"
  }
  ```

---

#### **Update Nurse Data**  
- **URL:** `PUT /nurse/{nurseId}` 
- **Description:** Updates the data for an existing nurse. Only the provided fields will be updated.
- **Path Parameter:** `nurseId` - The ID of the nurse.
- **Example Request Body:** 
  ```json
  {
    "name": "fiorella_updated"
  }
  ```
  
  ```json
  {
     "nurseId": 1,
     "name": "fiorella_updated",
     "user": "fiorella02",
     "password": "newpassword123"
  }
  ```

---

#### **Create a New Nurse**
- **URL:** `POST /nurse/createNurse`
- **Description:** Creates a new nurse in the database.
- **Example Response:**

  New user's details:
  ```json
  {
      "name": "Raven",
      "user": "Raven05",
      "password": "newpassword1234"
  }
   ```

Response:
```json
    {
       "nurseId": 14,
       "name": "Raven",
       "user": "Raven05",
       "password": "newpassword1234"
      }
  ```

---

#### **Delete a Nurse by ID** 
- **URL:** `DEL /nurse/{nurseId}`
- **Description:** Deletes a nurse by their ID from the database.
- **Path Parameter:** `nurseId` - The ID of the nurse.
- **Example Response:**
 
   Successful response: 204 No Content
  
   Unsuccessful response: 404 not found


  
