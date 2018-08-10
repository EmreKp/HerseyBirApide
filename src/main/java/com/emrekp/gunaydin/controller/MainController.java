package com.emrekp.gunaydin.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.emrekp.gunaydin.model.Currency;
import com.emrekp.gunaydin.model.MainModel;
import com.emrekp.gunaydin.service.CurrencyService;
import com.emrekp.gunaydin.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private final MainService mainService;

	@Autowired
	public MainController(MainService mainService) {
		this.mainService = mainService;
	}

	@GetMapping("/")
	public @ResponseBody
	MainModel gunaydin() {
		return mainService.gunaydin();
	}
}
