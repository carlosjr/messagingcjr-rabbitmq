package com.cjr.messagingrabbitmq.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cjr.messagingrabbitmq.config.MessagingDirectConfig;
import com.cjr.messagingrabbitmq.config.MessagingFanoutConfig;
import com.cjr.messagingrabbitmq.config.MessagingHeaderConfig;
import com.cjr.messagingrabbitmq.config.MessagingTopicConfig;

@Component
public class MessagingConsumer {

	@RabbitListener(queues = MessagingDirectConfig.QUEUENAME)
	public void consumeMessageDirect(Map<String, String> message) {
		try {
			Thread.sleep(30000);
			System.out.println("Mensagem recebida DIRECT com sucesso <" + message.get("id") + ">");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@RabbitListener(queues = {MessagingFanoutConfig.QUEUENAME1, MessagingFanoutConfig.QUEUENAME2} )
	public void consumeMessageFanout(Map<String, String> message) {
		try {
			Thread.sleep(30000);
			System.out.println("Mensagem recebida FANOUT com sucesso <" + message.get("id") + ">");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@RabbitListener(queues = MessagingTopicConfig.QUEUENAME_ALL)
	public void consumeMessageTopicAll(Map<String, String> message) {
		try {
			Thread.sleep(30000);
			System.out.println("Mensagem recebida TOPIC type ALL com sucesso <" + message.get("id") + ">");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@RabbitListener(queues = MessagingTopicConfig.QUEUENAME_FLA)
	public void consumeMessageTopicFla(Map<String, String> message) {
		try {
			Thread.sleep(30000);
			System.out.println("Mensagem recebida TOPIC type FLA com sucesso <" + message.get("id") + ">");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@RabbitListener(queues = {MessagingHeaderConfig.QUEUENAME1, MessagingHeaderConfig.QUEUENAMEALL, MessagingHeaderConfig.QUEUENAMEANY})
	public void consumeMessageHeader(String message) {
		try {
			Thread.sleep(30000);
			System.out.println("Mensagem recebida HEADER com sucesso <" + message + ">");
		} catch (InterruptedException e) {
		}
	}
	
}
