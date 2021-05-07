package com.cjr.messagingrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingDirectConfig {

	public static final String EXCHANGENAME = "cjr.exchange.direct";

	public static final String QUEUENAME = "cjr-queue-direct";
	
	public static final String ROUTINGKEYNAME = "cjr.routingkey.direct";
	
	@Bean
	public Queue queueDirect() {
		return new Queue(QUEUENAME, false);
	}
	
	@Bean
	public DirectExchange exchangeDirect() {
		return new DirectExchange(EXCHANGENAME);
	}
	
	@Bean
	public Binding bindingDirect(Queue queueDirect, DirectExchange exchangeDirect) {
		return BindingBuilder.bind(queueDirect).to(exchangeDirect).with(ROUTINGKEYNAME);
	}
}
