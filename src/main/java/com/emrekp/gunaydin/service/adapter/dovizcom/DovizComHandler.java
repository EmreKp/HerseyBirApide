package com.emrekp.gunaydin.service.adapter.dovizcom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.emrekp.gunaydin.model.Currency;
import com.emrekp.gunaydin.service.CurrencyHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Primary
public class DovizComHandler implements CurrencyHandler {

	@Value("${dovizcom.kur.url}")
	private String url;

	@Value("${dovizcom.altin.url}")
	private String goldUrl;

	private final RestTemplate restTemplate;

	@Autowired
	public DovizComHandler(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Currency> getCurrencies(List<String> units) {
		ResponseEntity<List<DovizComModel>> dovizComEntity = restTemplate.exchange(url,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<DovizComModel>>() {});

		Predicate<DovizComModel> predicate = c -> true; //default

		if (units != null) {
			predicate = c -> units.contains(c.getCode());
		}

		List<DovizComModel> dovizComList = dovizComEntity.getBody()
				.stream()
				.filter(predicate)
				.collect(Collectors.toList());

		List<Currency> currencies = new ArrayList<>();
		for (DovizComModel model : dovizComList) {
			Currency currency = new Currency();
			currency.setCode(model.getCode());
			currency.setValue(model.getBuying());

			currencies.add(currency);
		}

		//altın ekleme işlemi öbür url'de çünkü sadece kurlar mevcut
		ResponseEntity<List<DovizComModel>> dovizComGoldEntity = restTemplate.exchange(goldUrl,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<DovizComModel>>() {});

		if (units != null && units.contains("XAU")) {
			DovizComModel altinModel = dovizComGoldEntity.getBody()
					.stream().filter(c -> c.getShort_name().equals("Gram")).findAny().get();
			Currency goldCur = new Currency();
			goldCur.setCode("XAU");
			goldCur.setValue(altinModel.getBuying());

			currencies.add(goldCur);
		}

		return currencies;
	}
}
