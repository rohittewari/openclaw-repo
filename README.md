# openclaw-repo

## Spring Boot Overview

Spring Boot is a framework built on top of Spring that makes it easy to create production-ready Java applications quickly.

### Why Spring Boot?
- **Fast setup** with starter dependencies.
- **Auto-configuration** reduces boilerplate.
- **Embedded servers** (Tomcat/Jetty/Undertow) let you run apps directly.
- **Production-ready features** like health checks, metrics, and externalized configuration.

### Typical Project Structure
- `controller` — REST API endpoints
- `service` — business logic
- `repository` — database access layer
- `model/entity` — domain objects
- `resources/application.yml` — environment configuration

### Common Dependencies
- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `spring-boot-starter-test`

### Run the Application
```bash
./mvnw spring-boot:run
```

### Build a JAR
```bash
./mvnw clean package
java -jar target/<app-name>.jar
```

Spring Boot is ideal for building scalable microservices and RESTful APIs with clean architecture and rapid development speed.
