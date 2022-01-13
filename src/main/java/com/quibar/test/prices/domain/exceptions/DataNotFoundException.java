package com.quibar.test.prices.domain.exceptions;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5922411230755380410L;
	public static final String MESSAGE = "Price not found";

    public DataNotFoundException() {
        super(MESSAGE);
    }

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
