package com.quibar.test.prices.infra.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import com.quibar.test.prices.infra.dto.FindPriceRequest;

@Component
public class FindPriceRequestValidator extends AbstractValidator<FindPriceRequest>{

	public FindPriceRequestValidator(Validator validator) {
        super(validator);
    }

    @Override
    public Class<FindPriceRequest> getValidationClass() {
        return FindPriceRequest.class;
    }
}
