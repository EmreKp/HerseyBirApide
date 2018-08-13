package com.emrekp.gunaydin.service.adapter.accuweather;

import java.util.List;

import com.emrekp.gunaydin.model.Weather;
import com.emrekp.gunaydin.service.WeatherHandler;

import org.springframework.stereotype.Component;

@Component
public class AccuweatherHandler implements WeatherHandler {
	@Override
	public List<Weather> getWeathers(List<String> cities) {
		return null;
	}
}
