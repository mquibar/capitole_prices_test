package com.quibar.test.prices.infra.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.quibar.test.prices.infra.entity.BrandEntity;
import com.quibar.test.prices.infra.entity.PriceEntity;
import com.quibar.test.prices.infra.entity.ProductEntity;

public class BuilderUtils {

	private static final String ZARA = "ZARA";
	private static final String EUR = "EUR";
	
	public static BrandEntity brandBuilder() {
		return BrandEntity.builder()
				.id(1)
				.name(ZARA)
				.build();
	}
	
	public static ProductEntity productBuilder() {
		return  ProductEntity.builder()
				.id(35455L)
				.build();
	}

	public static List<PriceEntity> pricesBuilder(BrandEntity brand, ProductEntity product) {
		
		final var prices = new ArrayList<PriceEntity>();
		
		prices.add(PriceEntity.builder()
				.brand(brand)
				.startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
				.endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
				.priceList(1)
				.product(product)
				.priority((short)0)
				.value(BigDecimal.valueOf(35.50).setScale(2))
				.curr(EUR)
				.build());
		prices.add(PriceEntity.builder()
				.brand(brand)
				.startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
				.endDate(LocalDateTime.parse("2020-06-14T18:30:00"))
				.priceList(2)
				.product(product)
				.priority((short)1)
				.value(BigDecimal.valueOf(25.45).setScale(2))
				.curr(EUR)
				.build());
		prices.add(PriceEntity.builder()
				.brand(brand)
				.startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
				.endDate(LocalDateTime.parse("2020-06-15T11:00:00"))
				.priceList(3)
				.product(product)
				.priority((short)1)
				.value(BigDecimal.valueOf(30.50).setScale(2))
				.curr(EUR)
				.build());
		prices.add(PriceEntity.builder()
				.brand(brand)
				.startDate(LocalDateTime.parse("2020-06-15T16:00:00"))
				.endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
				.priceList(4)
				.product(product)
				.priority((short)1)
				.value(BigDecimal.valueOf(38.95).setScale(2))
				.curr(EUR)
				.build());
		return prices;
	}
}
