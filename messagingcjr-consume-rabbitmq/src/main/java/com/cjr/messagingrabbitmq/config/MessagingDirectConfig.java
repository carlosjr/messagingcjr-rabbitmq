package com.cjr.messagingrabbitmq.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingDirectConfig {

	public static final String QUEUENAME_TOCONSUMER = "cjr-queue-direct-to-consumer";
	
	public static final String QUEUENAME_DLQ = "cjr-queue-direct-dlq";
}
