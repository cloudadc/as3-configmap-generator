package io.github.cloudadc.config;

public class InvalidConfigExcaption extends RuntimeException {

	public InvalidConfigExcaption(String message) {
		super(message);
	}

	public InvalidConfigExcaption() {
		super();
	}

	public InvalidConfigExcaption(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = -6913116903530791750L;

}
