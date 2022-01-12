package com.quibar.test.prices.infra.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class ProductEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}
