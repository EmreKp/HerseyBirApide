package com.emrekp.gunaydin.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.emrekp.gunaydin.model.Currency;
import com.emrekp.gunaydin.model.MainModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	private final CurrencyService currencyService;

	@Autowired
	public MainService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	public MainModel gunaydin() {
		MainModel anaModel = new MainModel();

		//önce dövizi göster
		List<String> defaultUnits = Arrays.asList("USD", "EUR", "GBP", "XAU");
		List<Currency> currencies = currencyService.getCurrencies(defaultUnits);

		anaModel.setDolar(currencies.stream()
				.filter(c -> c.getCode().equals("USD")).findFirst().get().getValue());
		anaModel.setEuro(currencies.stream()
				.filter(c -> c.getCode().equals("EUR")).findFirst().get().getValue());
		anaModel.setPound(currencies.stream()
				.filter(c -> c.getCode().equals("GBP")).findFirst().get().getValue());
		anaModel.setAltin(currencies.stream()
				.filter(c -> c.getCode().equals("XAU")).findFirst().get().getValue());

		return anaModel;
	}
}
