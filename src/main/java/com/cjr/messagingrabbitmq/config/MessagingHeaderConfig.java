package com.cjr.messagingrabbitmq.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingHeaderConfig {

	public static final String EXCHANGENAME = "cjr.exchange.headers";

	public static final String QUEUENAME1 = "cjr-queue-headers-1";
	public static final String QUEUENAMEALL = "cjr-queue-headers-all";
	public static final String QUEUENAMEANY = "cjr-queue-headers-any";
	
	
	@Bean
	public Queue queueHeader1() {
		return new Queue(QUEUENAME1, false);
	}
	
	@Bean
	public Queue queueHeaderAll() {
		return new Queue(QUEUENAMEALL, false);
	}
	
	@Bean
	public Queue queueHeaderAny() {
		return new Queue(QUEUENAMEANY, false);
	}
	
	@Bean
	public HeadersExchange exchangeHeader() {
		return new HeadersExchange(EXCHANGENAME);
	}

	@Bean
	public Binding bindingHeader1(Queue queueHeader1, HeadersExchange exchangeHeader) {
		return BindingBuilder.bind(queueHeader1).to(exchangeHeader).where("format").matches("pdf");
	}
	
	@Bean
	public Binding bindingHeaderAll(Queue queueHeaderAll, HeadersExchange exchangeHeader) {
		Map<String, Object> keysHeader = new HashMap<>();
		keysHeader.put("format", "pdf");
		keysHeader.put("type", "report");
		return BindingBuilder.bind(queueHeaderAll).to(exchangeHeader).whereAll(keysHeader).match();
	}
	
	@Bean
	public Binding bindingHeaderAny(Queue queueHeaderAny, HeadersExchange exchangeHeader) {
		Map<String, Object> keysHeader = new HashMap<>();
		keysHeader.put("format", "doc");
		keysHeader.put("type", "log");
		return BindingBuilder.bind(queueHeaderAny).to(exchangeHeader).whereAny(keysHeader).match();
	}
}
