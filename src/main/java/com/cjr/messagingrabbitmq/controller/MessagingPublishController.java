package com.cjr.messagingrabbitmq.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjr.messagingrabbitmq.config.MessagingDirectConfig;
import com.cjr.messagingrabbitmq.config.MessagingFanoutConfig;
import com.cjr.messagingrabbitmq.config.MessagingHeaderConfig;
import com.cjr.messagingrabbitmq.config.MessagingTopicConfig;

@RestController
@RequestMapping("/publish")
public class MessagingPublishController {

	@Autowired
	private RabbitTemplate template;
	
	@PostMapping(path = "/send-direct")
	public String sendMessageDirect(@RequestBody String message) {
		System.out.println("Sending <" + message + ">");
		Map<String, String> acMap = new HashMap<>();
		acMap.put("id", message);
		template.convertAndSend(MessagingDirectConfig.EXCHANGENAME, MessagingDirectConfig.ROUTINGKEYNAME, acMap);
		
		return "Envio para fila DIRECT com Sucesso!";
	}
	
	@PostMapping(path = "/send-fanout")
	public String sendMessageFanout(@RequestBody String message) {
		System.out.println("Sending <" + message + ">");
		Map<String, String> acMap = new HashMap<>();
		acMap.put("id", message);
		template.convertAndSend(MessagingFanoutConfig.EXCHANGENAME, "", acMap);
		
		return "Envio para fila FANOUT com Sucesso!";
	}
	
	@PostMapping(path = "/send-topic/{routeType}")
	public String sendMessageTopic(@RequestBody String message, @PathVariable("routeType") String routeType) {
		System.out.println("Sending <" + message + ">");
		Map<String, String> acMap = new HashMap<>();
		acMap.put("id", message);
		
		if(routeType.equals("all")) {
			template.convertAndSend(MessagingTopicConfig.EXCHANGENAME, MessagingTopicConfig.ROUTINGKEYNAME_ALL, acMap);
		}else {
			template.convertAndSend(MessagingTopicConfig.EXCHANGENAME, "cjr.routingkey.topic." + routeType, acMap);
		}
		return "Envio para fila TOPIC com Sucesso! Type:" + routeType;
	}
	
	@PostMapping(path = "/send-header/{type}")
	public String sendMessageHeader(@RequestBody String message, @PathVariable("type") String type) {
		System.out.println("Sending <" + message + ">");
		Map<String, String> acMap = new HashMap<>();
		acMap.put("id", message);
		
		MessageProperties messageProperties = new MessageProperties();
		messageProperties.setHeader("format",  "pdf");
		messageProperties.setHeader("type", type);
		MessageConverter messageConverter = new SimpleMessageConverter();
		Message messageMq = messageConverter.toMessage(message, messageProperties);
		template.send(MessagingHeaderConfig.EXCHANGENAME, "", messageMq);

		return "Envio para fila HEADER com Sucesso! Type:" + type;
	}
	
}
