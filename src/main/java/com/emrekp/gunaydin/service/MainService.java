package com.emrekp.gunaydin.service;

import java.util.Arrays;
import java.util.List;

import com.emrekp.gunaydin.model.Currency;
import com.emrekp.gunaydin.model.MainModel;
import com.emrekp.gunaydin.model.Weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainService {

	private final CurrencyService currencyService;
	private final WeatherService weatherService;

	@Autowired
	public MainService(CurrencyService currencyService, WeatherService weatherService) {
		this.currencyService = currencyService;
		this.weatherService = weatherService;
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

		//şimdi de hava
		List<String> defaultCities = Arrays.asList("istanbul", "ankara", "izmir");
		List<Weather> weathers = weatherService.getWeather(defaultCities);

		anaModel.setIstanbul(weathers.stream()
				.filter(w -> w.getCity().equals("istanbul")).findFirst().get().getDay());
		anaModel.setAnkara(weathers.stream()
				.filter(w -> w.getCity().equals("ankara")).findFirst().get().getDay());
		anaModel.setIzmir(weathers.stream()
				.filter(w -> w.getCity().equals("izmir")).findFirst().get().getDay());

		return anaModel;
	}
}
