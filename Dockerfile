FROM openjdk:21-jdk-slim
ENV HOST 0.0.0.0
EXPOSE 8080
ADD target/doctor-appointment-system.jar doctor-appointment-system.jar
ENTRYPOINT ["java" ,"-jar","doctor-appointment-system.jar"]