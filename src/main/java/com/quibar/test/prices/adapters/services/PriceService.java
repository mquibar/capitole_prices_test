package com.quibar.test.prices.adapters.services;

import org.springframework.stereotype.Service;

import com.quibar.test.prices.adapters.dto.FindPriceRequest;
import com.quibar.test.prices.adapters.dto.FindPriceResponse;
import com.quibar.test.prices.domain.usecase.FindByDateProductCurrency;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceService {

	private final FindByDateProductCurrency findByDateProductCurrency;
	
	public FindPriceResponse findPrice (FindPriceRequest request) {
		var price = findByDateProductCurrency.execute(request.getApplicationDate(), request.getProductId(), request.getBrandId());
		return FindPriceResponse.builder()
				.product(price.getProduct().getId())
				.brand(price.getBrand().getId())
				.priceList(price.getPriceList())
				.startDate(price.getStartDate())
				.endDate(price.getEndDate())
				.price(price.getValue())
				.build();
				
	}
}
