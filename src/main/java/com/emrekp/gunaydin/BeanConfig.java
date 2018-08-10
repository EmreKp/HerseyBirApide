package com.emrekp.gunaydin;

import com.emrekp.gunaydin.service.CurrencyHandler;
import com.emrekp.gunaydin.service.adapter.dovizcom.DovizComHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
