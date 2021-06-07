# messagingcjr-rabbitmq

## Projeto exemplificando filas com RabbitMq e SpringBoot

### Exemplos com as Exchange:
- Direct
- Direct (to other app)
- Fanout
- Topic
- Headers

#### Broker RabbitMQ com docker
- docker run -d --rm -v /var/lib/rabbitmq:/var/lib/rabbitmq --hostname cjr-rabbit --name rabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin123  -p 5672:5672 -p 15672:15672 rabbitmq:3-management

Broker rodando em [http://localhost:15672/](url "http://localhost:15672/")  

### Rodar a aplicação no eclise (messagingcjr-pub-rabbitmq)
- botão direito no Arquivo MessagingRabbitmqApplication.java -> Run as... -> Run on Server
- ou, na pasta do projeto: java -jar **messagingcjr-pub-rabbitmq/build/libs/messagingcjr-pub-rabbitmq-0.0.1-SNAPSHOT.jar**]

Projeto rodando em [http://localhost:8080](url "http://localhost:8080")  

### Rodar a aplicação no eclise (messagingcjr-pub-rabbitmq)
- botão direito no Arquivo MessagingRabbitmqConsumeApplication.java -> Run as... -> Run on Server
- ou, na pasta do projeto: java -jar **messagingcjr-consume-rabbitmq/build/libs/messagingcjr-cosnume-rabbitmq-0.0.1-SNAPSHOT.jar**

Projeto rodando em [http://localhost:8081](url "http://localhost:8081")  


### OU: Subindo com docker-compose
- docker-compose build --no-cache
- docker-compose up

### Postman
- realizar testes com o Postman: https://www.getpostman.com/collections/80a0ba02b12dabc21662


