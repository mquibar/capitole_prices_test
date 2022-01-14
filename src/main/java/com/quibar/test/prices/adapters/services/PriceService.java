package com.quibar.test.prices.adapters.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.quibar.test.prices.adapters.dto.FindPriceDto;
import com.quibar.test.prices.adapters.dto.PriceDto;
import com.quibar.test.prices.domain.usecase.FindByDateProductCurrency;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceService {

	private final FindByDateProductCurrency findByDateProductCurrency;
	
	public PriceDto findPrice (FindPriceDto request) {
		var date = LocalDateTime.parse(request.getApplicationDate());
		var price = findByDateProductCurrency.execute(date, request.getProductId(), request.getBrandId());
		return PriceDto.builder()
				.product(price.getProduct().getId())
				.brand(price.getBrand().getId())
				.priceList(price.getPriceList())
				.startDate(price.getStartDate())
				.endDate(price.getEndDate())
				.price(price.getValue())
				.build();
				
	}
}
