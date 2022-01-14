package com.quibar.test.prices.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quibar.test.prices.infra.entity.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {

}
