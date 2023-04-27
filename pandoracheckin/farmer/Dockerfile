

FROM openjdk:17-jdk-alpine as builder
WORKDIR /fgservice/pandoracheckin/farmer
COPY ./pandoracheckin/farmer/pom.xml .
COPY ./pandoracheckin/farmer/mvnw .
COPY ./pandoracheckin/farmer/.mvn ./.mvn
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip

COPY ./pandoracheckin/farmer/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /fgservice

COPY --from=builder /fgservice/pandoracheckin/farmer/target/farmer-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "farmer-0.0.1-SNAPSHOT.jar"]

