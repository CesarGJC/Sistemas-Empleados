FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Cambiamos .jar por .war
COPY target/*.war app.war

EXPOSE 8089

# Ejecutamos el .war
ENTRYPOINT ["java", "-jar", "app.war"]