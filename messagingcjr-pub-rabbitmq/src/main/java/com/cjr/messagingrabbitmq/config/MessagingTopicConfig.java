package com.cjr.messagingrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingTopicConfig {

	public static final String EXCHANGENAME = "cjr.exchange.topic";

	public static final String QUEUENAME_ALL = "cjr-queue-topic-all";
	public static final String QUEUENAME_FLA = "cjr-queue-topic-fla";
	
	public static final String ROUTINGKEYNAME_ALL = "cjr.routingkey.topic.#";
	public static final String ROUTINGKEYNAME_FLA = "cjr.routingkey.topic.*.flamengo";
	
	@Bean
	public Queue queueTopicAll() {
		return new Queue(QUEUENAME_ALL, false);
	}
	
	@Bean
	public Queue queueTopicFla() {
		return new Queue(QUEUENAME_FLA, false);
	}
	
	@Bean
	public TopicExchange exchangeTopic() {
		return new TopicExchange(EXCHANGENAME);
	}

	@Bean
	public Binding bindingTopicAll(Queue queueTopicAll, TopicExchange exchangeTopic) {
		return BindingBuilder.bind(queueTopicAll).to(exchangeTopic).with(ROUTINGKEYNAME_ALL);
	}
	
	@Bean
	public Binding bindingTopic(Queue queueTopicFla, TopicExchange exchangeTopic) {
		return BindingBuilder.bind(queueTopicFla).to(exchangeTopic).with(ROUTINGKEYNAME_FLA);
	}
}
