#Image de base
FROM openjdk:17-alpine
LABEL maintainer="sir-soir@gmail.com"
VOLUME /sir-data
ADD target/sir2022-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8082
#java -jar
ENTRYPOINT ["java", "-jar", "/app.jar"]