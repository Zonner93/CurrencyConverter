FROM adoptopenjdk:11-jre-hotspot

RUN ../mvnw clean compile package
ARG JAR_FILE=../target/*.jar
COPY ${JAR_FILE} CurrencyConverter.jar
ENTRYPOINT ["java", "-jar", "CurrencyConverter.jar"]
