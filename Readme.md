# University Management System (UMS)

A RESTful web application built with **Spring Boot 3**, **Spring Security**, **JWT**, and **PostgreSQL** to manage users (Admin, Teacher, Student), courses, and enrollments. The application follows clean architecture and design patterns such as DTO, Factory, and Strategy.

---

## Features

- User authentication with JWT (Login & Register)
- Role-based access control (`ADMIN`, `TEACHER`, `STUDENT`)
- CRUD operations for:
  - Students
  - Courses
  - Enrollments
- Clean service-repository-controller architecture
- MapStruct for DTO mapping
- PostgreSQL integration with JPA
- Optional: Swagger UI for API testing

---

## Technologies Used

- Java 21
- Spring Boot 3.4.4
- Spring Security
- JWT (jjwt)
- Spring Data JPA
- PostgreSQL
- MapStruct
- Flyway (disabled)
- Dotenv (for environment variables)
- Lombok

---

## How to Run

### Prerequisites

- JDK 21+
- PostgreSQL 14+
- Maven 3.9+
- `.env` file with DB credentials

### Environment Setup

Create a `.env` file in the project root:


DB_USERNAME=postgres DB_PASSWORD=your_db_password


### ▶️ Build and Run

```bash
# Clean and install dependencies
.\mvnw.cmd clean install

# Run the app
.\mvnw.cmd spring-boot:run
Application runs at:
http://localhost:8080


Project Structure
src/main/java/com/yourorg/ums
├── config/               # Flyway, Swagger (optional)
├── controller/           # REST controllers
├── dto/                  # DTOs for API input/output
├── entity/               # JPA Entities
├── exception/            # Custom exceptions
├── mapper/               # MapStruct interfaces
├── repository/           # Spring Data JPA interfaces
├── security/             # JWT and security configuration
├── service/              # Business logic
└── UmsApplication.java   # Main Spring Boot class


Example API Endpoints
 Auth:
 POST /auth/register
 POST /auth/login

 Students:
 GET /students
 POST /students
 GET /students/{id}
 PUT /students/{id}
 DELETE /students/{id}

 Courses:
 GET /courses
 POST /courses

 Enrollments:
 POST /enrollments
 GET /enrollments