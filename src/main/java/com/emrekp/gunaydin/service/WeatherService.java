package com.emrekp.gunaydin.service;

import java.util.List;

import com.emrekp.gunaydin.model.Weather;

import org.springframework.stereotype.Service;

@Service
public class WeatherService {

	private final WeatherHandler handler;

	public WeatherService(WeatherHandler handler) {
		this.handler = handler;
	}

	public List<Weather> getWeather(List<String> cities) {
		return this.handler.getWeathers(cities);
	}
}
