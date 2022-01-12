package com.quibar.test.prices.infra.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quibar.test.prices.infra.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

	List<PriceEntity> findByStartDateGreaterThanEqualAndEndDateLessThanEqualAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime startDate, LocalDateTime endDate, long productId, int brandId);
	
}
