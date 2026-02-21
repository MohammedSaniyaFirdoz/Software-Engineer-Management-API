🚀 Software Engineer Management API

A RESTful backend API built using Spring Boot and PostgreSQL implementing full CRUD operations with layered architecture.

🛠 Tech Stack

Java 21

Spring Boot

Spring Data JPA (Hibernate)

PostgreSQL

Maven

Validation API

🏗 Architecture

Controller → Service → Repository → Database

📌 Features

Create new software engineer (POST)

Get all engineers (GET)

Get engineer by ID (GET)

Update engineer (PUT)

Proper 404 error handling

Input validation with @NotBlank

▶ How to Run

Clone repository

Create PostgreSQL database named springboot

Update application.properties with DB credentials

Run Spring Boot application

📡 API Endpoints

GET
/api/v1/Software-engineers

GET
/api/v1/Software-engineers/{id}

POST
/api/v1/Software-engineers

PUT
/api/v1/Software-engineers/{id}