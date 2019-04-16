FROM openjdk:8-alpine
COPY target/Auth-Service-0.0.1-SNAPSHOT.jar /Auth-Service.jar
EXPOSE 80/tcp
ENTRYPOINT ["java","-jar","/Auth-Service.jar"]
