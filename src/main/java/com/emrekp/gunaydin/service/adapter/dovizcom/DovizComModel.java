package com.emrekp.gunaydin.service.adapter.dovizcom;

import java.math.BigDecimal;

public class DovizComModel {
	private String code;
	private BigDecimal buying;
	private BigDecimal selling;
	private String short_name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getBuying() {
		return buying;
	}

	public void setBuying(BigDecimal buying) {
		this.buying = buying;
	}

	public BigDecimal getSelling() {
		return selling;
	}

	public void setSelling(BigDecimal selling) {
		this.selling = selling;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}
}
