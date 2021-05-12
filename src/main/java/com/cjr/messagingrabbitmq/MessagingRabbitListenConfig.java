package com.cjr.messagingrabbitmq;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingRabbitListenConfig {
	
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
	  ConnectionFactory connectionFactory,
	  SimpleRabbitListenerContainerFactoryConfigurer configurer) {
	      SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	      configurer.configure(factory, connectionFactory);
	      factory.setErrorHandler(new CustomErrorHandler());
	      return factory;
	}
}
