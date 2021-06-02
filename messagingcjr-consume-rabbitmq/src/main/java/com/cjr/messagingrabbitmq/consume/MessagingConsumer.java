package com.cjr.messagingrabbitmq.consume;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.cjr.messagingrabbitmq.config.MessagingDirectConfig;
import com.cjr.messagingrabbitmq.exception.ConsumerException;

@Component
public class MessagingConsumer {

	@RabbitListener(queues = MessagingDirectConfig.QUEUENAME_TOCONSUMER)
	public void consumeMessageDirect(Map<String, String> message) throws ConsumerException {
		try {
			System.out.println("Processando... MSG "+message.get("id"));
			Thread.sleep(10000);
			if(message.get("id").contains("ERROR")) {
				throw new ConsumerException();
			}
			System.out.println("Mensagem recebida DIRECT com sucesso <" + message.get("id") + ">");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
