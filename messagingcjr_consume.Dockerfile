FROM openjdk:14

RUN mkdir -p /opt/code

COPY messagingcjr-consume-rabbitmq/ /opt/code/

WORKDIR /opt/code

RUN ./gradlew build -x test

EXPOSE 8081 8081

CMD ["java", "-jar", "build/libs/messagingcjr-consume-rabbitmq-0.0.1-SNAPSHOT.jar"]
