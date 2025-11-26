FROM eclipse-temurin:17-jdk-alpine AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw package -DskipTests


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]