package com.emrekp.gunaydin.service;

import java.util.List;

import com.emrekp.gunaydin.model.Currency;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

	private final CurrencyHandler handler;

	public CurrencyService(CurrencyHandler handler) {
		this.handler = handler;
	}

	public List<Currency> getCurrencies(List<String> units) {
		return this.handler.getCurrencies(units);
	}
}
