# Quiz Management Microservices

A backend Quiz Management System built using **Spring Boot Microservices**. The project demonstrates service discovery with **Eureka Server** and inter-service communication using **OpenFeign**. It consists of independent services responsible for managing questions and quizzes.

---

## 🚀 Features

### 📚 Question Service
- Add new questions
- Retrieve all questions
- Generate questions based on category and difficulty
- Evaluate submitted answers

### 📝 Quiz Service
- Create quizzes dynamically
- Fetch questions from Question Service using OpenFeign
- Submit quiz responses
- Calculate quiz score

### ☁️ Service Discovery
- Eureka Server for service registration and discovery
- Dynamic communication between microservices

---

## 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Cloud Eureka
- OpenFeign
- Spring Data JPA
- MySQL
- Maven
- Lombok

---

## 📂 Project Structure

```
quiz-management-microservices
│
├── eureka-server
├── question-service
└── quiz-service
```

---

## ⚙️ Getting Started

### Clone the Repository

```bash
git clone https://github.com/sharmayush06/quiz-management-microservices.git
cd quiz-management-microservices
```

### Configure MySQL

Update the `application.properties` file of each service.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### Run the Services

Start the services in the following order:

1. Eureka Server
2. Question Service
3. Quiz Service

After starting the services, open:

```
http://localhost:8761
```

to verify that both services are registered with Eureka.

---

## 📡 API Endpoints

### Question Service

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/question/all` | Get all questions |
| POST | `/question/add` | Add a new question |
| POST | `/question/selected` | Generate questions |
| POST | `/question/result` | Calculate quiz score |

### Quiz Service

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/quiz/create` | Create a new quiz |
| GET | `/quiz/get/{id}` | Get quiz questions |
| POST | `/quiz/result` | Submit quiz answers |

---

## 🔄 Architecture

```
                 Client
                    │
                    ▼
             Quiz Service
                    │
              OpenFeign
                    │
                    ▼
             Question Service
                    │
                    ▼
                 MySQL

        ▲
        │
   Eureka Server
(Service Discovery)
```

---

## 🚧 Future Improvements

- API Gateway
- Spring Security with JWT
- Docker & Docker Compose
- Resilience4j Circuit Breaker
- Config Server
- Unit & Integration Testing
- Swagger/OpenAPI Documentation
- Centralized Logging

---

## 👨‍💻 Author

**Ayush Sharma**

- GitHub: https://github.com/sharmayush06
- B.Tech CSE Student | Aspiring Backend Developer
