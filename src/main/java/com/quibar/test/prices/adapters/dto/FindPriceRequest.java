package com.quibar.test.prices.adapters.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class FindPriceRequest {

	private LocalDateTime applicationDate;
	private long productId;
	private int brandId;
}
