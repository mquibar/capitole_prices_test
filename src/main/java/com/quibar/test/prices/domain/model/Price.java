package com.quibar.test.prices.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Price {

	private long id;
	private Brand brand;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private int priceList;
	private Product product;
	private short priority;
	private BigDecimal value;
	private String curr;
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public LocalDateTime getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}


	public LocalDateTime getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}


	public int getPriceList() {
		return priceList;
	}


	public void setPriceList(int priceList) {
		this.priceList = priceList;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product poduct) {
		this.product = poduct;
	}


	public short getPriority() {
		return priority;
	}


	public void setPriority(short priority) {
		this.priority = priority;
	}


	public BigDecimal getValue() {
		return value;
	}


	public void setValue(BigDecimal value) {
		this.value = value;
	}


	public String getCurr() {
		return curr;
	}


	public void setCurr(String curr) {
		this.curr = curr;
	}

	public static PriceBuilder builder() {
		return new PriceBuilder();
	}

	public static class PriceBuilder {
		
		private Price price = new Price();
		
		public PriceBuilder id(long id) {
			this.price.id = id;
			return this;
		}
		
		public PriceBuilder brand(Brand brand) {
			this.price.brand = brand;
			return this;
		}
		
		public PriceBuilder startDate(LocalDateTime startDate) {
			this.price.startDate = startDate;
			return this;
		}
		
		public PriceBuilder endDate(LocalDateTime endDate) {
			this.price.endDate = endDate;
			return this;
		}
		
		public PriceBuilder priceList(int priceList) {
			this.price.priceList = priceList;
			return this;
		}
		
		public PriceBuilder product(Product product) {
			this.price.product = product;
			return this;
		}
		
		public PriceBuilder priority(short priority) {
			this.price.priority = priority;
			return this;
		}
		
		public PriceBuilder value(BigDecimal value) {
			this.price.value = value;
			return this;
		}
		
		public PriceBuilder curr(String curr) {
			this.price.curr = curr;
			return this;
		}
		
		public Price build() {
			return this.price;
		}
	}
}
