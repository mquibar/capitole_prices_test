package com.quibar.test.prices.domain.exceptions;

public class PriceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -5922411230755380410L;
	public static final String MESSAGE = "Price not found";

    public PriceNotFoundException() {
        super(MESSAGE);
    }

    public PriceNotFoundException(String message) {
        super(message);
    }

    public PriceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
