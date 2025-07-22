Here's a sample `README.md` for your **Champions League Player Stats API** project, summarizing all key features:

---

# ⚽ Champions League Player Stats API

A Spring Boot RESTful web service providing access to detailed player statistics for the UEFA Champions League. Includes features like player search, filtering, authentication, a true/false guessing game, and Swagger UI documentation.

## 🚀 Features

* ✅ REST API to:

  * List all players
  * Filter by **team**, **nation**, or **position**
  * Add/delete players (admin-only)
* 🔍 Search endpoints by player name
* 🧠 True/False guessing game based on player stats
* 📊 Displays **Top 3 players** on the homepage (based on goals or logic you define)
* 🔒 Role-based Authorization with **hashed passwords**
* 🧪 Unit & Integration Testing (JUnit, Mockito)
* 📘 Swagger/OpenAPI Documentation
* 🛠 PostgreSQL + **Liquibase** for DB version control
* 🌐 Web scraping from FBRef.com to populate player data
* 🧾 Uses `application.yml` for clean config

## 🧱 Tech Stack

* Java 21 / Spring Boot 3
* Spring Security
* Spring Data JPA (PostgreSQL)
* Liquibase
* Swagger UI (springdoc-openapi)
* Railway (for PostgreSQL hosting)
* Maven

## 🛠 How to Run Locally

1. Clone the repo:

   ```bash
   git clone https://github.com/your-username/champions-league-api.git
   cd champions-league-api
   ```

2. Set up `application.yml` under `src/main/resources`:

   ```yaml
   spring:
     datasource:
       url: jdbc:postgresql://your-railway-db-url
       username: your_username
       password: your_password
     jpa:
       hibernate:
         ddl-auto: update
       show-sql: true
       properties:
         hibernate:
           dialect: org.hibernate.dialect.PostgreSQLDialect
           format_sql: true
     liquibase:
       change-log: classpath:db/changelog/db.changelog-master.yaml
   ```

3. Run the app:

   ```bash
   ./mvnw spring-boot:run
   ```

4. Access Swagger Docs:

   ```
   http://localhost:8080/swagger-ui.html
   ```

## 🎮 Game API (True or False)

* `GET /api/game/random`: Returns player stats (but hides name)
* `POST /api/game/validate`: Validates if the user guessed the player correctly

## 🛡 Authorization

* User roles: `ADMIN`, `USER`
* Passwords are securely stored with hashing
* Certain endpoints are restricted based on role

## 🧪 Testing

* JUnit + Mockito-based service and controller layer testing
* Use `mvn test` to run all tests

## 📦 Deployment

* Easily deployable on [Railway](https://railway.app)
* Database hosted on Railway PostgreSQL

## 📚 Liquibase

ChangeLog file located in:

```
src/main/resources/db/changelog/db.changelog-master.yaml
```

## 📌 Future Improvements

* Add rate limiting with Bucket4j
* Add asynchronous job handling for scraping or analytics
* Integrate CI/CD

---

Would you like this as a downloadable file or pushed into your project automatically?
