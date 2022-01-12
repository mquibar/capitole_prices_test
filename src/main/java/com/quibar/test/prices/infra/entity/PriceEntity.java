package com.quibar.test.prices.infra.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.quibar.test.prices.domain.model.Product;

import lombok.Data;

@Entity
@Table(name = "price")
@Data
public class PriceEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private BrandEntity brand;
	
	@Column(name = "start_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime startDate;
	
	@Column(name = "end_date",columnDefinition = "TIMESTAMP")
	private LocalDateTime endDate;
	
	@Column(name = "price_list")
	private int priceList;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product poduct;
	
	@Column
	private short priority;
	
	@Column(name = "price")
	private BigDecimal value;
	
	@Column
	private String curr;
}
