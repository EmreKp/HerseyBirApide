package com.emrekp.gunaydin.service.adapter.currencylayer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.emrekp.gunaydin.model.Currency;
import com.emrekp.gunaydin.service.CurrencyHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyLayerHandler implements CurrencyHandler {
	@Override
	public List<Currency> getCurrencies(List<String> units) {
		return null;
	}

	/*@Value("${currency.url}")
	private String url;

	@Value("${currencylayer.api_key}")
	private String apiKey;

	private static final BigDecimal troyOzToGr = new BigDecimal(31.1034768);

	private final RestTemplate restTemplate;

	@Autowired
	public CurrencyLayerHandler(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Currency> getCurrencies() {

		/*String currencyParams = "";

		if (currencies != null) {
			currencyParams = String.join(",", currencies);
		}

		//get from rest
		CurrencyLayerModel currencyLayer = restTemplate.getForObject(
				url + apiKey,
				CurrencyLayerModel.class
		);
		CurrencyLayerQuotes quotes = Objects.requireNonNull(currencyLayer).getQuotes();

		//check for usd first then calculate others by it
		BigDecimal usd = quotes.getDollar();
		Currency usdCurrency = new Currency();
		usdCurrency.setCode("USD");
		usdCurrency.setValue(usd);

		BigDecimal eur = usd.divide(quotes.getEuro(), BigDecimal.ROUND_FLOOR);
		Currency eurCurrency = new Currency();
		eurCurrency.setCode("EUR");
		eurCurrency.setValue(eur);

		BigDecimal gbp = usd.divide(quotes.getPound(), BigDecimal.ROUND_FLOOR);
		Currency gbpCurrency = new Currency();
		gbpCurrency.setCode("GBP");
		gbpCurrency.setValue(gbp);

		BigDecimal goldToTrOz = usd.divide(quotes.getGold(), BigDecimal.ROUND_FLOOR);
		BigDecimal goldGr = goldToTrOz.divide(troyOzToGr, BigDecimal.ROUND_FLOOR);
		Currency goldCurrency = new Currency();
		goldCurrency.setCode("XAU");
		goldCurrency.setValue(goldGr);

		//create list
		return Arrays.asList(usdCurrency, eurCurrency, gbpCurrency, goldCurrency);*/
}
