package com.cjr.messagingrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingFanoutConfig {

	public static final String EXCHANGENAME = "cjr.exchange.fanout";

	public static final String QUEUENAME1 = "cjr-queue-fanout-1";
	
	public static final String QUEUENAME2 = "cjr-queue-fanout-2";
	
	@Bean
	public Queue queueFanout1() {
		return new Queue(QUEUENAME1, false);
	}
	
	@Bean
	public Queue queueFanout2() {
		return new Queue(QUEUENAME2, false);
	}
	
	@Bean
	public FanoutExchange exchangeFanout() {
		return new FanoutExchange(EXCHANGENAME);
	}

	@Bean
	public Binding bindingFanout1(Queue queueFanout1, FanoutExchange exchangeFanout) {
		return BindingBuilder.bind(queueFanout1).to(exchangeFanout);
	}
	
	@Bean
	public Binding bindingFanout2(Queue queueFanout2, FanoutExchange exchangeFanout) {
		return BindingBuilder.bind(queueFanout2).to(exchangeFanout);
	}
}
