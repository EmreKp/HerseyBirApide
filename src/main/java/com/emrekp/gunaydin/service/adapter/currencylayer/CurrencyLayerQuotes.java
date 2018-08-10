package com.emrekp.gunaydin.service.adapter.currencylayer;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyLayerQuotes {

	//all units converted to dollar
	private BigDecimal dollar; //which is try
	private BigDecimal euro;
	private BigDecimal pound;
	private BigDecimal gold;

	@JsonProperty("USDTRY")
	public BigDecimal getDollar() {
		return dollar;
	}

	public void setDollar(BigDecimal dollar) {
		this.dollar = dollar;
	}

	@JsonProperty("USDEUR")
	public BigDecimal getEuro() {
		return euro;
	}

	public void setEuro(BigDecimal euro) {
		this.euro = euro;
	}

	@JsonProperty("USDGBP")
	public BigDecimal getPound() {
		return pound;
	}

	public void setPound(BigDecimal pound) {
		this.pound = pound;
	}

	@JsonProperty("USDXAU")
	public BigDecimal getGold() {
		return gold;
	}

	public void setGold(BigDecimal gold) {
		this.gold = gold;
	}
}
