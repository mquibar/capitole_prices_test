package com.quibar.test.prices.domain.usecase;

import java.time.LocalDateTime;

import com.quibar.test.prices.domain.dao.PriceDao;
import com.quibar.test.prices.domain.exceptions.PriceNotFoundException;
import com.quibar.test.prices.domain.model.Price;

public class FindByDateProductCurrency {

	private final PriceDao priceDao;
	
	public FindByDateProductCurrency(PriceDao priceDao) {
		this.priceDao = priceDao;
	}

	public Price execute(LocalDateTime applicationDate, long productId, String currency){
		return priceDao.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndCurrOrderByPriorityDesc(applicationDate, applicationDate, productId, currency)
				.stream()
				.findFirst()
				.orElseThrow(() -> new PriceNotFoundException("Price not found for those parameters"));
	}
}
