package com.emrekp.gunaydin.service.adapter.weatherbit;

import java.util.Arrays;
import java.util.Optional;

import com.emrekp.gunaydin.model.WeatherState;

public enum WeatherbitEnum {

	FEW_CLOUDS(WeatherState.CLOUDY, 801),
	SCATTERED(WeatherState.BROKEN_CLOUDY, 802),
	BROKEN_CLOUDY(WeatherState.BROKEN_CLOUDY, 803),
	OVERCAST_CLOUDS(WeatherState.OVER_CLOUDY, 804),
	CLEAR_SKY(WeatherState.CLEAR, 800),
	SNOW(WeatherState.SNOWY, 601),
	SNOW_RAIN(WeatherState.SNOWY_RAINY, 610);
	//TODO will be completed

	private WeatherState weather;
	private Integer code;

	WeatherbitEnum(WeatherState weather, Integer code) {
		this.weather = weather;
		this.code = code;
	}

	public WeatherState getWeather() {
		return weather;
	}

	public Integer getCode() {
		return code;
	}

	public static WeatherState getWeather(int code) {
		Optional<WeatherbitEnum> weatherEnumExists = Arrays
				.stream(WeatherbitEnum.values())
				.filter(w -> w.getCode() == code)
				.findFirst();

		if (weatherEnumExists.isPresent()) {
			return weatherEnumExists.get().getWeather();
		}
		else {
			throw new RuntimeException("Code not found.");
		}
	}
}
