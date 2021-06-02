FROM openjdk:14

RUN mkdir -p /opt/code

COPY messagingcjr-pub-rabbitmq/ /opt/code/

WORKDIR /opt/code

RUN ./gradlew clean build

EXPOSE 8080 8080

CMD ["java", "-jar", "build/libs/messagingcjr-pub-rabbitmq-0.0.1-SNAPSHOT.jar"]
