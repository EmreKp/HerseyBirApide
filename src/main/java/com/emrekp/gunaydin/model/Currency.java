package com.emrekp.gunaydin.model;

import java.math.BigDecimal;

public class Currency {
	private String code;
	private BigDecimal value;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
}
