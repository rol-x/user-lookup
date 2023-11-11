# User Lookup - Spring Boot Project
User Lookup is a Spring Boot-based application designed for user data retrieval. The application showcases backend functionalities with a focus on clean architecture and modular design.

## Try it out
Run the application from your IDE or from the command line using `mvn spring-boot:run`.

### Endpoint
Either visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) and test out the `/api/v1/users/{login}` endpoint or run:
```
curl localhost:8080/api/v1/users/{login}
```

### Database
The application by default uses in-memory H2 database. You can access the console by visiting [http://localhost:8080/h2-console](http://localhost:8080/h2-console) and logging in using the following data:
```
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:mem:users
User Name: sa
Password:
```

The password is left blank.

### Persistence
In order for the data not to be lost upon restarting the application, edit your Run Configuration and set the profile to `persist`. This will use a local database in a file, which will change the connection string to the following:
```
JDBC URL: jdbc:h2:file:~/users
```

## Features
- User data retrieval from external service with option to add more providers
- Saving each successful request in a database
- Liquibase for painless local setup
- API Documentation in Swagger
- Exception handling
- Scalable architecture
- No: security, validation, containerization, and more...

## Tech Stack
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **OpenAPI & Swagger**
- **OpenFeign**
- **H2 Database**
- **JUnit 5, AssertJ, Mockito**
- **Lombok**
- **Maven**
- **YAML**
