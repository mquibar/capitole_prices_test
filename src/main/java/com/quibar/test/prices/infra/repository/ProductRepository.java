package com.quibar.test.prices.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quibar.test.prices.infra.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
