package com.emrekp.herseybirapide.Model.Weather;

public class WeatherResponse {
    private Daily daily;
    private Currently currently;

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public Currently getCurrently() {
        return currently;
    }

    public void setCurrently(Currently currently) {
        this.currently = currently;
    }
}
