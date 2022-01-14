package com.quibar.test.prices.adapters.dto;

import lombok.Data;

@Data
public class FindPriceDto {

	private String applicationDate;
	private long productId;
	private int brandId;
		
}
