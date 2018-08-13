package com.emrekp.gunaydin.model;

public enum WeatherState {

	SUNNY("güneşli"),
	CLOUDY("bulutlu"),
	BROKEN_CLOUDY("parçalı bulutlu"),
	OVER_CLOUDY("çok bulutlu"),
	RAINY("yağmurlu"),
	HEAVY_RAINY("sağanak yağışlı"),
	CLEAR("açık"),
	SNOWY("karlı"),
	SNOWY_RAINY("karla karışık yağmurlu");

	private String status;

	WeatherState(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
