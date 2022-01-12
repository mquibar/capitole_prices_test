package com.quibar.test.prices.domain.model;

public class Product {

	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static ProductBuilder builder() {
		return new ProductBuilder();
	}
	
	public static class ProductBuilder{
		private Product product = new Product();
		
		public ProductBuilder id(long id) {
			this.product.id = id;
			return this;
		}
		
		public Product build() {
			return product;
		}
	}
}
