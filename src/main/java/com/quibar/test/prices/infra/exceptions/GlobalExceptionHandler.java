package com.quibar.test.prices.infra.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.quibar.test.prices.domain.exceptions.DataNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RequiredArgsConstructor
@Configuration
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	public static final String CODE = "code";
	public static final String MESSAGE = "message";
	public static final String STATUS = "status";
	public static final String FIELDS = "fields";
	public static final String CAMPOS_INVALIDOS = "Campos invalidos";
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<Object> handleException(Exception ex, Object body, WebRequest request) {
		log.error("handleException {}",ex.getLocalizedMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	
	@ExceptionHandler(ResponseStatusException.class)
	public final ResponseEntity<ExceptionResponse> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {

		log.error("handleValidatoinException {}",ex.getLocalizedMessage());
		final var response = ExceptionResponse.builder()
				.message(ex.getMessage())
				.build();

		return new ResponseEntity<>(response, ex.getStatus());
	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var response = new ExceptionResponse();
		response.setMessage(CAMPOS_INVALIDOS);
		

		List<FieldValidation> fields = ex.getBindingResult().getFieldErrors().stream()
				.map(x -> {
					try {
						return new FieldValidation(x.getField(), x.getDefaultMessage() );
					} catch (Exception e) {
			            return new FieldValidation(x.getField(), x.getDefaultMessage());
			        }
				}).collect(Collectors.toList());

		log.error("Argumentos invalidos: {}", fields);
		response.setFields(fields);

		return new ResponseEntity<>(response, headers, status);
	}
	
	
	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleDataNotFound(DataNotFoundException ex, WebRequest request){
		
		log.error("Data Not Found {}",ex.getMessage());
		
		var response = ExceptionResponse.builder()
				.message(ex.getMessage())
				.build();
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	
}
