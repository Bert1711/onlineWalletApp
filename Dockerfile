FROM openjdk:17
EXPOSE 8081
COPY onlineWalletApp-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]