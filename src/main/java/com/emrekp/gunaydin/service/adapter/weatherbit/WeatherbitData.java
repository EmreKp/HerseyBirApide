package com.emrekp.gunaydin.service.adapter.weatherbit;

public class WeatherbitData {

	private Double max_temp;
	private Double min_temp;
	private WeatherbitWeather weather;

	public Double getMax_temp() {
		return max_temp;
	}

	public void setMax_temp(Double max_temp) {
		this.max_temp = max_temp;
	}

	public Double getMin_temp() {
		return min_temp;
	}

	public void setMin_temp(Double min_temp) {
		this.min_temp = min_temp;
	}

	public WeatherbitWeather getWeather() {
		return weather;
	}

	public void setWeather(WeatherbitWeather weather) {
		this.weather = weather;
	}
}
