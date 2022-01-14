package com.quibar.test.prices.infra.validation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.quibar.test.prices.infra.exceptions.BadRequestException;
import com.quibar.test.prices.infra.exceptions.FieldValidation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractValidator<T> implements Validator {

    private final Validator validator;

    public abstract Class<T> getValidationClass();

    @Override
    public boolean supports(Class<?> aClass) {
        return getValidationClass().isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        validator.validate(o, errors);
    }


    public void validate(Object o) {
        final BindingResult errors = new BeanPropertyBindingResult(getValidationClass(), getValidationClass().getName());
        validator.validate(o, errors);
        if (errors.hasErrors()) {
        	List<FieldValidation> fields = errors.getFieldErrors()
        			.stream()
        			.map(fieldError -> {
        				String msg = fieldError.getDefaultMessage();
        				String field = fieldError.getField();
        				return new FieldValidation(field,msg);
        				})
        			.collect(Collectors.toList());
        	throw new BadRequestException(fields);
        }
    }
}