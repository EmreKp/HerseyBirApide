package com.emrekp.gunaydin.controller;

import java.util.List;

import com.emrekp.gunaydin.model.Weather;
import com.emrekp.gunaydin.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

	private final WeatherService weatherService;

	@Autowired
	public WeatherController(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	@GetMapping("/hava")
	public @ResponseBody
	List<Weather> getCurrency(@RequestParam(required = false) List<String> cities) {
		return weatherService.getWeather(cities);
	}
}
