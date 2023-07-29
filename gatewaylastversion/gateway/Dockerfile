FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/gatewaylastversion/gateway
COPY ./gatewaylastversion/gateway/pom.xml .
COPY ./gatewaylastversion/gateway/mvnw .
COPY ./gatewaylastversion/gateway/.mvn ./.mvn
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./gatewaylastversion/gateway/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice
EXPOSE 8085
COPY --from=builder /fgservice/gatewaylastversion/gateway/target/gateway-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "gateway-0.0.1-SNAPSHOT.jar"]
