package com.quibar.test.prices.infra.config;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.quibar.test.prices.infra.repository.BrandRepository;
import com.quibar.test.prices.infra.repository.PriceRepository;
import com.quibar.test.prices.infra.repository.ProductRepository;
import com.quibar.test.prices.infra.utils.BuilderUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InitialDataBuilder {

	private final PriceRepository repository;
	private final BrandRepository brandRepository;
	private final ProductRepository productRepository;
	
	@PostConstruct
	public void createData() {
		final var brand = BuilderUtils.brandBuilder();
		brandRepository.save(brand);
		final var product = BuilderUtils.productBuilder();
		productRepository.save(product);
		final var prices = BuilderUtils.pricesBuilder(brand, product);
		
		repository.saveAll(prices);
		
	}
}
