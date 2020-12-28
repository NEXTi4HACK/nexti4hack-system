# Build Docker Image Webapp
FROM openjdk:11-jre-slim
WORKDIR /app
COPY ./build/libs/nexti4hack-webapp.jar /app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","nexti4hack-webapp.jar"]