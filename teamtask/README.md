# Team Task Manager

A full-stack web application where users can create projects, assign tasks, and track progress with role-based access control.

---

# Features

- User Signup & Login
- Role-Based Access (Admin / Member)
- Create & Manage Projects
- Create & Assign Tasks
- Task Status Tracking
- Dashboard for Overdue Tasks
- REST APIs with Spring Boot
- MySQL Database Integration

---

# Tech Stack

## Frontend
- HTML
- CSS
- JavaScript

## Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA

## Database
- MySQL

## Tools
- IntelliJ IDEA
- MySQL Workbench
- Postman
- GitHub
- Railway

---

# Project Structure

```bash
src
 └── main
      ├── java
      │    └── com.teamtask.teamtask
      │          ├── controller
      │          ├── entity
      │          ├── repository
      │          └── config
      │
      └── resources
           ├── static
           │     ├── login.html
           │     ├── signup.html
           │     ├── dashboard.html
           │     ├── projects.html
           │     ├── tasks.html
           │     ├── style.css
           │     └── script.js
           │
           └── application.properties
```

---

# Database Setup

Create database in MySQL:

```sql
CREATE DATABASE teamtask;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/teamtask
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Run Project

## Clone Repository

```bash
git clone https://github.com/rastogi-harsh/teamtask.git
```

---

## Run Spring Boot Application

Run:

```bash
TeamtaskApplication.java
```

---

# Application URLs

```text
http://localhost:8080/signup.html
http://localhost:8080/login.html
http://localhost:8080/dashboard.html
http://localhost:8080/projects.html
http://localhost:8080/tasks.html
```

---

# API Endpoints

## Authentication

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/auth/signup | Register User |
| POST | /api/auth/login | Login User |

---

## Projects

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/projects | Get All Projects |
| POST | /api/projects | Create Project |

---

## Tasks

| Method | Endpoint | Description |
|---|---|---|
| GET | /api/tasks | Get All Tasks |
| POST | /api/tasks | Create Task |
| GET | /api/tasks/overdue | Get Overdue Tasks |

---

# Roles

## ADMIN
- Create Projects
- Manage Tasks
- Assign Tasks

## MEMBER
- View Tasks
- Update Task Status

---

# Deployment

Application deployed using Railway.

---

# Author

Harsh Rastogi