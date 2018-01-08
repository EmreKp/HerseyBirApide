package com.emrekp.herseybirapide.Model.Weather;

import java.util.List;

public class Daily {
    private List<WeatherData> data;

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }
}
