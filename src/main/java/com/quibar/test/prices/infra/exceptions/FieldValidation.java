package com.quibar.test.prices.infra.exceptions;

import lombok.Data;

@Data
public class FieldValidation {
	private String name;
	private String msg;

	public FieldValidation(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
	}
}