package com.emrekp.gunaydin.controller;

import java.util.List;

import com.emrekp.gunaydin.model.Currency;
import com.emrekp.gunaydin.service.CurrencyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

	private final CurrencyService currencyService;

	public CurrencyController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@GetMapping("/doviz")
	public @ResponseBody
	List<Currency> getCurrency(@RequestParam(required = false) List<String> currencies) {
		return currencyService.getCurrencies(); //TODO adaptörü düzenle
	}
}
