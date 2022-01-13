package com.quibar.test.prices.domain.usecase;

import java.time.LocalDateTime;

import com.quibar.test.prices.domain.dao.PriceDao;
import com.quibar.test.prices.domain.exceptions.DataNotFoundException;
import com.quibar.test.prices.domain.model.Price;

public class FindByDateProductCurrency {

	private final PriceDao priceDao;
	
	public FindByDateProductCurrency(PriceDao priceDao) {
		this.priceDao = priceDao;
	}

	public Price execute(LocalDateTime applicationDate, long productId, int brandId){
		return priceDao.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(applicationDate, applicationDate, productId, brandId)
				.stream()
				.findFirst()
				.orElseThrow(() -> new DataNotFoundException("Price not found for those parameters"));
	}
}
