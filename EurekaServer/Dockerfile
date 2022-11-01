# To build:  docker build -t macdrop-eureka .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/EurekaServer-1.0-SNAPSHOT.jar /opt/app/eureka.jar
CMD ["java", "-jar", "/opt/app/eureka.jar"]
