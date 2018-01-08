package com.emrekp.herseybirapide.Service;

import com.emrekp.herseybirapide.Model.Weather.GeoResult;
import com.emrekp.herseybirapide.Model.Weather.Geolocation;
import com.emrekp.herseybirapide.Model.Weather.WeatherData;
import com.emrekp.herseybirapide.Model.Weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    private RestTemplate restTemplate;

    @Autowired
    public WeatherService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Integer getWeather(String city){
        Integer weather = null;
        //get coords first
        String mapsKey = "AIzaSyBEZRaiRyG6TinQHQ79JiCKSZZ1GHkNVXQ";
        String mapsURL = "https://maps.googleapis.com/maps/api/geocode/json?address=" + city;
        mapsURL += "&key=" + mapsKey;
        Geolocation geolocation = restTemplate.getForObject(mapsURL, Geolocation.class);
        GeoResult geoResult = geolocation.getResults().get(0); //tek eleman olacak genelde
        Double latitude = geoResult.getGeometry().getLocation().getLat();
        Double longitude = geoResult.getGeometry().getLocation().getLng();

        String darkskyKey = "763276aeb743b4cb8120a0b89b90cb09";
        String apiURL = "https://api.darksky.net/forecast/" + darkskyKey + "/";
        apiURL += latitude + "," + longitude + "?exclude=minutely,hourly,alerts,currently,flags&units=si";
        Long currentTime = System.currentTimeMillis() / 1000;
        WeatherResponse response = restTemplate.getForObject(apiURL, WeatherResponse.class);
        List<WeatherData> dataList = response.getDaily().getData();
        for (WeatherData data : dataList) {
            long time = data.getTime();
            long nextDay = time + 86400;
            if (time <= currentTime && currentTime < nextDay) {
                weather = data.getTemperatureHigh().intValue();
                break;
            }
        }
        return weather;
    }
}
