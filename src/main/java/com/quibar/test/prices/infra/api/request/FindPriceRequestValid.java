package com.quibar.test.prices.infra.api.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.quibar.test.prices.adapters.dto.FindPriceRequest;

public class FindPriceRequestValid extends FindPriceRequest {

	@NotNull
	@Override
	public LocalDateTime getApplicationDate() {
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
