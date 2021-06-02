package com.cjr.messagingrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingDirectConfig {

	public static final String EXCHANGENAME = "cjr.exchange.direct";
	
	public static final String EXCHANGENAME_DLQ = "cjr.exchange.direct.dlq";
	
	public static final String QUEUENAME = "cjr-queue-direct";
	
	public static final String QUEUENAME_TOCONSUMER = "cjr-queue-direct-to-consumer";
	
	public static final String QUEUENAME_DLQ = "cjr-queue-direct-dlq";
	
	public static final String ROUTINGKEYNAME = "cjr.routingkey.direct";
	
	public static final String ROUTINGKEYNAME_TOCONSUMER = "cjr.routingkey.direct.to.consumer";
	
	public static final String ROUTINGKEYNAME_DLQ = "cjr.routingkey.direct.dlq";
	
	
	@Bean
	public DirectExchange exchangeDirect() {
		return new DirectExchange(EXCHANGENAME);
	}

	@Bean
	public Queue queueDirect() {
		return QueueBuilder.durable(QUEUENAME).withArgument("x-dead-letter-exchange", EXCHANGENAME_DLQ)
				.withArgument("x-dead-letter-routing-key", ROUTINGKEYNAME_DLQ).build();
	}
	
	@Bean
	public Binding bindingDirect() {
		return BindingBuilder.bind(queueDirect()).to(exchangeDirect()).with(ROUTINGKEYNAME);
	}

	// queue to consumer other server
	@Bean
	public Queue queueDirectToConsumer() {
		return new Queue(QUEUENAME_TOCONSUMER, false);
	}
	
	@Bean
	public Binding bindingDirectToConsumer() {
		return BindingBuilder.bind(queueDirectToConsumer()).to(exchangeDirect()).with(ROUTINGKEYNAME_TOCONSUMER);
	}	
	
	
	// dead letter
	@Bean 
	public DirectExchange exchangeDirectDlq() { 
		return new DirectExchange (EXCHANGENAME_DLQ); 
	} 
	
	@Bean
	public Queue queueDirectDlq() {
		return QueueBuilder.durable(QUEUENAME_DLQ).build();
	}

	@Bean
	public Binding bindingDlq() {
		return BindingBuilder.bind(queueDirectDlq()).to(exchangeDirectDlq()).with(ROUTINGKEYNAME_DLQ);
	}
	
}
