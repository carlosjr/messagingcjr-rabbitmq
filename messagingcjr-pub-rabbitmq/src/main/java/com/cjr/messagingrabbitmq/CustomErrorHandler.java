package com.cjr.messagingrabbitmq;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

import com.cjr.messagingrabbitmq.exception.ConsumerException;

@Component
public class CustomErrorHandler implements ErrorHandler {

	@Override
	public void handleError(Throwable t) {
		System.out.println("Redelivered error message queue: " + t.getMessage());
		if ((t.getCause() instanceof ConsumerException)) {
            throw new AmqpRejectAndDontRequeueException("Error Handler converted exception to fatal", t);
        }
	}
}
