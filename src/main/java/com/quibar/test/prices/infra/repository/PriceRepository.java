package com.quibar.test.prices.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quibar.test.prices.infra.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

}
