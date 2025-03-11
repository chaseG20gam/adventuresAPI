# Adventures API

AdventuresAPI is a CRUD application built using Java, Spring Boot, and MySQL. It allows users to manage a collection of travel adventures by creating, reading, updating, and deleting entries through a simple web interface.
This is an example project I made to put my knowledge to the test.

## Features
- Add, edit, and delete adventure entries
- Store details such as date, country, city, state, number of photos, and blog completion status
- Responsive UI with a cyberpunk 2077 aesthetic

## Prerequisites
Before running the application, ensure you have the following installed:
- Java 17 or later
- MySQL Server
- Maven

## Installation and Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/adventuresAPI.git
cd adventuresAPI
```

### 2. Configure Database
Create a MySQL database named `adventures_db` and update the `application.properties` file with your database credentials:
```
spring.datasource.url=jdbc:mysql://localhost:3306/adventures_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```
There is a SQL file inside resources that contains a quick set up to quickly create and fill a database with some adventures.

### 3. Build and Run the Application
Use Maven to build and run the project:
```bash
mvn spring-boot:run
```
The application will start at `http://localhost:8080`.

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/adventures` | Retrieve all adventures |
| GET | `/api/adventures/{id}` | Retrieve a specific adventure |
| POST | `/api/adventures` | Add a new adventure |
| PUT | `/api/adventures/{id}` | Update an existing adventure |
| DELETE | `/api/adventures/{id}` | Delete an adventure |

## Frontend Usage
Once the backend is running, the frontend will also be running on the browser at localhost:8080. There you will be able to interact with the table, the buttons and the input fields, modifying the database with each request.
