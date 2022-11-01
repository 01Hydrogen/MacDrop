
# To build:  docker build -t macdrop-delivery .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/Delivery-1.0-SNAPSHOT.jar /opt/app/delivery.jar
CMD ["java", "-jar", "/opt/app/delivery.jar"]
