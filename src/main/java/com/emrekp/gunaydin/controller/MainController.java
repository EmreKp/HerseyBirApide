package com.emrekp.gunaydin.controller;

import java.util.List;
import java.util.Optional;

import com.emrekp.gunaydin.model.Currency;
import com.emrekp.gunaydin.model.MainModel;
import com.emrekp.gunaydin.service.CurrencyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private final CurrencyService currencyService;

	@Autowired
	public MainController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@GetMapping("/")
	public @ResponseBody
	MainModel gunaydin() {

		MainModel anaModel = new MainModel();

		//döviz
		List<Currency> currencies = currencyService.getCurrencies();
		Optional<Currency> dolar = currencies.stream().filter(c -> c.getCode().equals("USD")).findAny();
		dolar.ifPresent(currency -> anaModel.setDolar(currency.getValue()));

		Optional<Currency> euro = currencies.stream().filter(c -> c.getCode().equals("EUR")).findAny();
		euro.ifPresent(currency -> anaModel.setEuro(currency.getValue()));

		Optional<Currency> pound = currencies.stream().filter(c -> c.getCode().equals("GBP")).findAny();
		pound.ifPresent(currency -> anaModel.setPound(currency.getValue()));

		Optional<Currency> gold = currencies.stream().filter(c -> c.getCode().equals("XAU")).findAny();
		gold.ifPresent(currency -> anaModel.setAltin(currency.getValue()));

		return anaModel;
	}
}
