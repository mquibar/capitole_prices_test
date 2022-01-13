package com.quibar.test.prices.infra.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class ExceptionResponse {
	private String message;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime dateTime;
	
	private List<FieldValidation> fields;

    public ExceptionResponse() {
		dateTime = LocalDateTime.now();
    }
    
    @Builder
	public ExceptionResponse(String message, List<FieldValidation> fields) {
		this.message = message;
		this.fields = fields;
		dateTime = LocalDateTime.now();
	}
}
