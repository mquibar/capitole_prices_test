package com.quibar.test.prices.infra.mappers;

import org.springframework.stereotype.Component;

import com.quibar.test.prices.domain.model.Brand;
import com.quibar.test.prices.domain.model.Price;
import com.quibar.test.prices.domain.model.Product;
import com.quibar.test.prices.infra.entity.BrandEntity;
import com.quibar.test.prices.infra.entity.PriceEntity;
import com.quibar.test.prices.infra.entity.ProductEntity;

@Component
public class PriceEntityMapper {

	public PriceEntity domainTo(Price price) {
		var brandEntity = BrandEntity.builder()
				.id(price.getBrand().getId())
				.name(price.getBrand().getName())
				.build();
		var productEntity = ProductEntity.builder()
				.id(price.getProduct().getId())
				.build();
		return PriceEntity.builder()
			.id(price.getId())
			.brand(brandEntity)
			.startDate(price.getStartDate())
			.endDate(price.getEndDate())
			.priceList(price.getPriceList())
			.product(productEntity)
			.priority(price.getPriority())
			.curr(price.getCurr())
			.build();
	}

	public Price toDomain(PriceEntity entity) {
		var brand = Brand.builder()
				.id(entity.getBrand().getId())
				.name(entity.getBrand().getName())
				.build();
		var product = Product.builder()
				.id(entity.getProduct().getId())
				.build();
		return Price.builder()
				.id(entity.getId())
				.brand(brand)
				.startDate(entity.getStartDate())
				.endDate(entity.getEndDate())
				.priceList(entity.getPriceList())
				.product(product)
				.priority(entity.getPriority())
				.curr(entity.getCurr())
				.build();
	}

}
