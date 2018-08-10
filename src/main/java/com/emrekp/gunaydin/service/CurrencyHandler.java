package com.emrekp.gunaydin.service;

import java.util.List;

import com.emrekp.gunaydin.model.Currency;

public interface CurrencyHandler {
	List<Currency> getCurrencies(List<String> units);
}
