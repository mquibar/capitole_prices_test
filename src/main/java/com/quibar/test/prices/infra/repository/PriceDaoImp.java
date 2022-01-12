package com.quibar.test.prices.infra.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.quibar.test.prices.domain.dao.PriceDao;
import com.quibar.test.prices.domain.model.Price;
import com.quibar.test.prices.infra.mappers.PriceEntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceDaoImp implements PriceDao {
	
	private final PriceEntityMapper mapper;
	private final PriceRepository repository;

	@Override
	public Price save(Price price) {
		var entity = mapper.domainTo(price);
		entity = repository.save(entity);
		return mapper.toDomain(entity);
	}

	@Override
	public List<Price> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(
			LocalDateTime startDate, LocalDateTime endDate, long product, int brandId) {
		return repository.findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(startDate, endDate, product, brandId)
				.stream()
				.map(mapper::toDomain)
				.collect(Collectors.toList());
	}

}
