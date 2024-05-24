FROM openjdk:17-alpine
EXPOSE 8081
COPY target/onlineWalletApp-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
