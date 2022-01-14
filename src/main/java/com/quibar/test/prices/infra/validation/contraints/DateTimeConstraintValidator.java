package com.quibar.test.prices.infra.validation.contraints;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateTimeConstraintValidator implements ConstraintValidator<DateTime, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.isBlank()) {
			return false;
		}
		try {
			LocalDateTime.parse(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
