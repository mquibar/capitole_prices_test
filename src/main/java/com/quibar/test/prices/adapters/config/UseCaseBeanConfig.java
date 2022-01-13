package com.quibar.test.prices.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quibar.test.prices.domain.dao.PriceDao;
import com.quibar.test.prices.domain.usecase.FindByDateProductCurrency;

@Configuration
public class UseCaseBeanConfig {

	@Bean
	public FindByDateProductCurrency findByDateProductCurrency(PriceDao priceDao) {
		return new FindByDateProductCurrency(priceDao);
	}
}
