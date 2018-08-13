package com.emrekp.gunaydin.service;

import java.util.List;

import com.emrekp.gunaydin.model.Weather;

public interface WeatherHandler {
	List<Weather> getWeathers(List<String> cities);
}
