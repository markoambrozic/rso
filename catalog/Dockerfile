FROM openjdk:8-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./target/rso-ecommerce-catalog-1.0.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD java -jar rso-ecommerce-catalog-1.0.0-SNAPSHOT.jar