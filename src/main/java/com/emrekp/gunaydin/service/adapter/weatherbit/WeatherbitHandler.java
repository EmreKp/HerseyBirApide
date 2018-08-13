package com.emrekp.gunaydin.service.adapter.weatherbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.emrekp.gunaydin.model.Weather;
import com.emrekp.gunaydin.service.WeatherHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Primary
public class WeatherbitHandler implements WeatherHandler {

	@Value("${weatherbit.url}")
	private String url;

	@Value("${weatherbit.api_key}")
	private String apiKey;

	private final RestTemplate restTemplate;

	@Autowired
	public WeatherbitHandler(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Weather> getWeathers(List<String> cities) {
		List<Weather> weathers = new ArrayList<>();

		if (cities == null || cities.isEmpty()) {
			//81 il ekle
			cities = Arrays.asList(
					"adana", "adıyaman", "afyon", "ağrı", "amasya", "ankara",
					"antalya", "artvin", "aydın", "balıkesir", "bilecik", "bingöl",
					"bitlis", "bolu", "burdur", "bursa", "çanakkale", "çankırı",
					"çorum", "denizli", "diyarbakır", "edirne", "elazığ", "erzincan",
					"erzurum", "eskişehir", "gaziantep", "giresun", "gümüşhane", "hakkari",
					"hatay", "isparta", "mersin", "istanbul", "izmir", "kars",
					"kastamonu", "kayseri", "kırklareli", "kırşehir", "izmit", "konya",
					"kütahya", "malatya", "manisa", "kahramanmaraş", "mardin", "muğla",
					"muş", "nevşehir", "niğde", "ordu", "rize", "sakarya",
					"samsun", "siirt", "sinop", "sivas", "tekirdağ", "tokat",
					"trabzon", "tunceli", "şanlıurfa", "uşak", "van", "yozgat",
					"zonguldak", "aksaray", "bayburt", "karaman", "kırıkkale", "batman",
					"şırnak", "bartın", "ardahan", "iğdır", "yalova", "karabük",
					"kilis", "osmaniye", "düzce");
		}

		for (String city : cities) {
			//make request
			String cityUrl = this.makeUrl(city);
			WeatherbitModel weatherbitModel = restTemplate.getForObject(cityUrl, WeatherbitModel.class);
			WeatherbitData weatherModel = weatherbitModel.getData().get(0);

			//set model
			Weather weather = new Weather();
			weather.setCity(city);
			weather.setDay(weatherModel.getMax_temp().intValue());
			weather.setNight(weatherModel.getMin_temp().intValue());
			int statusCode = weatherModel.getWeather().getCode();
			weather.setState(WeatherbitEnum.getWeather(statusCode).getStatus());

			weathers.add(weather);
		}

		return weathers;
	}

	private String makeUrl(String city) {
		return url + "?city=" + city + "&key=" + apiKey;
	}
}
