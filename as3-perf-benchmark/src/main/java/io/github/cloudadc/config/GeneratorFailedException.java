package io.github.cloudadc.config;

public class GeneratorFailedException extends RuntimeException {

	private static final long serialVersionUID = -3438619745195332412L;

	public GeneratorFailedException() {
		super();
	}

	public GeneratorFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public GeneratorFailedException(String message) {
		super(message);
	}

	public GeneratorFailedException(Throwable cause) {
		super(cause);
	}

}
