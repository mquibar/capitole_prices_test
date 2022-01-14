package com.quibar.test.prices.infra.exceptions;

import java.util.List;

public class BadRequestException extends RuntimeException {

	
	private static final long serialVersionUID = -978789692497515415L;
	public static final String MESSAGE = "Bad Request";
	public final List<FieldValidation> fields;

    public BadRequestException(List<FieldValidation> fields) {
        super(MESSAGE);
        this.fields = fields;
    }

    public BadRequestException(String message,List<FieldValidation> fields) {
        super(message);
        this.fields = fields;
    }

    public BadRequestException(String message, Throwable cause, List<FieldValidation> fields) {
        super(message, cause);
        this.fields=fields;
    }
    
    public List<FieldValidation> getFields() {
		return fields;
	}
}
