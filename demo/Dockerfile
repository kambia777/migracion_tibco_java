# Etapa 1: Construccion
FROM maven:3.9.11-eclipse-temurin-25 AS build
WORKDIR /app

# Copiamos pom.xml primero para aprovechar la cache de Maven
COPY pom.xml .
# Copiamos el código fuente
COPY src ./src

# Compilamos el proyecto y generamos el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final para ejecutar la app
FROM eclipse-temurin:25-jdk
WORKDIR /app

# Copiamos el JAR desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Define variables de entorno (pueden ser sobrescritas al ejecutar el contenedor)
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/tfg?useSSL=false&serverTimezone=UTC

# Exponemos el puerto de la app
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
