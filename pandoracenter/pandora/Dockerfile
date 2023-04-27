FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/pandoracenter/pandora
COPY ./pandoracenter/pandora/pom.xml .
COPY ./pandoracenter/pandora/mvnw .
COPY ./pandoracenter/pandora/.mvn ./.mvn
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./pandoracenter/pandora/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice

COPY --from=builder /fgservice/pandoracenter/pandora/target/pandora-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "pandora-0.0.1-SNAPSHOT.jar"]
