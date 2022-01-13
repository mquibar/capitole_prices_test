package com.quibar.test.prices.adapters.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FindPriceResponse {

	private long product;
	private int brand;
	private int priceList;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private BigDecimal price;
	
}
