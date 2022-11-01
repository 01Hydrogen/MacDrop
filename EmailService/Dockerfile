# To build:  docker build -t macdrop-email-srv .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/EmailService-1.0-SNAPSHOT.jar /opt/app/email-srv.jar
CMD ["java", "-jar", "/opt/app/email-srv.jar"]
