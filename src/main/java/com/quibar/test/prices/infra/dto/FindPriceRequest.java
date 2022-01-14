package com.quibar.test.prices.infra.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.quibar.test.prices.adapters.dto.FindPriceDto;
import com.quibar.test.prices.infra.validation.contraints.DateTime;

public class FindPriceRequest extends FindPriceDto {

	@NotBlank
	@DateTime
	@Override
	public String getApplicationDate() {
		return super.getApplicationDate();
	}
	
	@NotNull
	@Override
	public int getBrandId() {
		return super.getBrandId();
	}
	
	@NotNull
	@Override
	public long getProductId() {
		return super.getProductId();
	}
	
	
}
