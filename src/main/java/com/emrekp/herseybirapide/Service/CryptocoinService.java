package com.emrekp.herseybirapide.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptocoinService {
    private RestTemplate restTemplate;
    private CurrencyService currencyService;

    public CryptocoinService(CurrencyService currencyService, RestTemplate restTemplate) {
        this.currencyService = currencyService;
        this.restTemplate = restTemplate;
    }

    public Double coinAl(String name) throws Exception {
        String baseURL = "https://api.bitfinex.com/v2/ticker/";
        String ticker = "t" + name.toUpperCase() + "USD";
        Double[] coins = restTemplate.getForObject(baseURL + ticker, Double[].class);
        Double value = coins[0];
        Float dolarKuru = currencyService.neKadar("USD");
        return value * dolarKuru;
    }

    //TODO çıktı mı düştü mü eklemeyi düşünebilirsin

}
