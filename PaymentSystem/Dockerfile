# To build:  docker build -t macdrop-payment .

#check jdk version
FROM eclipse-temurin:8-jdk
RUN mkdir /opt/app
COPY ./target/PaymentSystem-1.0-SNAPSHOT.jar /opt/app/payment.jar
CMD ["java", "-jar", "/opt/app/payment.jar"]
