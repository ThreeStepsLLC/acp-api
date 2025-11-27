FROM eclipse-temurin:17-jdk-alpine AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw package -DskipTests


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Create user for running the application
RUN addgroup -g 1000 appuser && \
    adduser -D -u 1000 -G appuser appuser

COPY --from=build target/*.jar app.jar
RUN chown appuser:appuser app.jar

USER appuser
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]