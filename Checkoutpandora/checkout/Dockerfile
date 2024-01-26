FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/Checkoutpandora/checkout
COPY ./Checkoutpandora/checkout/pom.xml .
COPY ./Checkoutpandora/checkout/mvnw .
COPY ./Checkoutpandora/checkout/.mvn ./.mvn
RUN dos2unix ./mvnw
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./Checkoutpandora/checkout/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice

COPY --from=builder /fgservice/Checkoutpandora/checkout/target/checkout-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "checkout-0.0.1-SNAPSHOT.jar"]
