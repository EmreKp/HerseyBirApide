package com.emrekp.herseybirapide.Service;

import com.emrekp.herseybirapide.Model.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CurrencyService {
    private RestTemplate restTemplate;

    public CurrencyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Float neKadar(String code) throws Exception {
        Float amount = null;
        String TCMB_URL = "http://www.tcmb.gov.tr/kurlar/today.xml";
        CurrencyResponse currencyResponse = restTemplate.getForObject(TCMB_URL, CurrencyResponse.class);
        List<CurrencyResponse.Currency> currencies = currencyResponse.getCurrency();
        for (CurrencyResponse.Currency currency : currencies) {
            String currencyCode = currency.getCurrencyCode();
            if (currencyCode.equals(code)) {
                return currency.getForexBuying();
            }
        }
        throw new Exception("Kodu yanlış girdin yiğenim");
    }
}
