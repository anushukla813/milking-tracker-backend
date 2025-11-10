FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY src ./src
RUN ./mvnw clean install -DskipTests
FROM eclipse-temurin:21-jre-alpine
ENV PORT 8080
EXPOSE 8080
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]