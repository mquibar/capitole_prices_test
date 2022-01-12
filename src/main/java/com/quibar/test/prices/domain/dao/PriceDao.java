package com.quibar.test.prices.domain.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.quibar.test.prices.domain.model.Price;

public interface PriceDao {

	Price save(Price price);
	
	List<Price> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndCurrOrderByPriorityDesc(LocalDateTime startDate, LocalDateTime endDate, long product, String curr);
}
