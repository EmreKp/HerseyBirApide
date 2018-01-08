package com.emrekp.herseybirapide.Controller;

import com.emrekp.herseybirapide.Model.CurrencyResponse;
import com.emrekp.herseybirapide.Model.Response;
import com.emrekp.herseybirapide.Service.CurrencyService;
import com.emrekp.herseybirapide.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {
    private WeatherService weatherService;
    private CurrencyService currencyService;
    private RestTemplate restTemplate;

    @Autowired
    public MainController(WeatherService weatherService, CurrencyService currencyService, RestTemplate restTemplate) {
        this.weatherService = weatherService;
        this.currencyService = currencyService;
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/")
    public Response donder() throws Exception {
        Response response = new Response();

        //tarih saat
        LocalDate tarih = LocalDate.now();
        LocalTime saat = LocalTime.now();
        DateTimeFormatter tarihFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter saatFormat = DateTimeFormatter.ofPattern("HH:mm");
        response.setTarih(tarih.format(tarihFormat));
        response.setSaat(saat.format(saatFormat));

        //weather
        response.setIstanbul(weatherService.getWeather("İstanbul"));
        response.setAnkara(weatherService.getWeather("Ankara"));
        response.setIzmir(weatherService.getWeather("İzmir"));

        //currency
        response.setDolar(currencyService.neKadar("USD"));
        response.setEuro(currencyService.neKadar("EUR"));
        response.setSterlin(currencyService.neKadar("GBP"));

        return response;
    }
}
