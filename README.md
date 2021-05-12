# messagingcjr-rabbitmq

#### Broker RabbitMQ com docker
- docker run -d --rm -v rabbitmq_data:/var/lib/rabbitmq --hostname cjr-rabbit --name rabbitmq -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin123  -p 5672:5672 -p 15672:15672 rabbitmq:3-management