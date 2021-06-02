package com.cjr.messagingrabbitmq.exception;

public class ConsumerFatalException extends RuntimeException{

	private static final long serialVersionUID = 8241913943565348454L;
	
	public ConsumerFatalException() {
		super();
	}

	public ConsumerFatalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConsumerFatalException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConsumerFatalException(String message) {
		super(message);
	}

	public ConsumerFatalException(Throwable cause) {
		super(cause.getMessage());
	}

}
