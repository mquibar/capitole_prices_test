package com.quibar.test.prices.domain.model;

public class Brand {

	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static BrandBuilder builder() {
		return new BrandBuilder();
	}


	public static class BrandBuilder {
		private Brand brand = new Brand();
		
		public BrandBuilder id(int id) {
			this.brand.id = id;
			return this;
		}
		public BrandBuilder name(String name) {
			this.brand.name = name;
			return this;
		}
		
		public Brand build() {
			return this.brand;
		}
	}
}
