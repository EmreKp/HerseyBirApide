package com.emrekp.herseybirapide.Controller;

import com.emrekp.herseybirapide.Model.Namaz;
import com.emrekp.herseybirapide.Model.NamazTimes.Ilce;
import com.emrekp.herseybirapide.Model.NamazTimes.Sehir;
import com.emrekp.herseybirapide.Model.NamazTimes.Vakit;
import com.emrekp.herseybirapide.Model.Response;
import com.emrekp.herseybirapide.Service.CryptocoinService;
import com.emrekp.herseybirapide.Service.CurrencyService;
import com.emrekp.herseybirapide.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


@RestController
public class MainController {
    private WeatherService weatherService;
    private CurrencyService currencyService;
    private CryptocoinService cryptocoinService;
    private RestTemplate restTemplate;

    @Autowired
    public MainController(WeatherService weatherService, CurrencyService currencyService, CryptocoinService cryptocoinService,
                          RestTemplate restTemplate) {
        this.weatherService = weatherService;
        this.currencyService = currencyService;
        this.cryptocoinService = cryptocoinService;
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
        //TODO havanın nasıl olacağını da bi şekilde ekle

        //currency
        response.setDolar(currencyService.neKadar("USD"));
        response.setEuro(currencyService.neKadar("EUR"));
        response.setSterlin(currencyService.neKadar("GBP"));

        //cryptocurrency
        response.setBitcoin(cryptocoinService.coinAl("BTC").intValue());
        response.setEthereum(cryptocoinService.coinAl("ETH").intValue());

        return response;
    }

    @RequestMapping("/namaz")
    public Namaz namaz(@RequestParam String il) throws Exception {
        Namaz namaz = new Namaz();
        String baseURL = "https://ezanvakti.herokuapp.com";
        Sehir[] sehirObj = restTemplate.getForObject(baseURL + "/sehirler?ulke=2", Sehir[].class);
        List<Sehir> sehirler = Arrays.asList(sehirObj);
        Integer sehirID = null;
        String sehirAd = null;
        for (Sehir sehir : sehirler) {
            if (sehir.getSehirAdi().equalsIgnoreCase(il)) {
                sehirID = sehir.getSehirID();
                sehirAd = sehir.getSehirAdi();
                break;
            }
        } //şimdi şehirdeki ilçelere bak aynı isimi görürsen yapış
        Ilce[] ilceObj = restTemplate.getForObject(baseURL + "/ilceler?sehir=" + sehirID, Ilce[].class);
        List<Ilce> ilceler = Arrays.asList(ilceObj);
        Integer ilceID = null;
        for (Ilce ilce : ilceler) {
            if (ilce.getIlceAdi().equals(sehirAd)) {
                ilceID = ilce.getIlceID();
                break;
            }
        }

        Vakit[] vakitObj = restTemplate.getForObject(baseURL + "/vakitler?ilce=" + ilceID, Vakit[].class);
        List<Vakit> vakitler = Arrays.asList(vakitObj);
        Vakit vakit = vakitler.get(0); //ilki bugün
        namaz.setSabah(vakit.getGunes());
        namaz.setOgle(vakit.getOgle());
        namaz.setIkindi(vakit.getIkindi());
        namaz.setAksam(vakit.getAksam());
        namaz.setYatsi(vakit.getYatsi());

        return namaz;
    }

    //TODO puan durumu ekle

    //ÖNEMLİ NOT: Rest Controller ve viewlar ayrı yerlerde olmalıdırlar
}
