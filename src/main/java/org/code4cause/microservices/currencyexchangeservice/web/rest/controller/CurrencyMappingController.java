package org.code4cause.microservices.currencyexchangeservice.web.rest.controller;

import java.util.Optional;

import org.code4cause.microservices.currencyexchangeservice.dto.SuccessResponse;
import org.code4cause.microservices.currencyexchangeservice.model.CurrencyMapping;
import org.code4cause.microservices.currencyexchangeservice.service.CurrencyMappingService;
import org.code4cause.microservices.currencyexchangeservice.web.rest.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyMappingController {

	private CurrencyMappingService currencyMappingService;

	@Value("${server.port}")
	private Integer serverPort;

	public CurrencyMappingController(final CurrencyMappingService currencyMappingService) {
		this.currencyMappingService = currencyMappingService;
	}

	@GetMapping(path = { "/currency-exchange/from/{from}/to/{to}" })
	public ResponseEntity<SuccessResponse<CurrencyMapping>> getCurrencyMapping(@PathVariable String from,
			@PathVariable String to) {
		final Optional<CurrencyMapping> currencyMapping = currencyMappingService.findByFromAndToCurrnecy(from, to);

		if (currencyMapping.isEmpty()) {
			throw new ResourceNotFoundException("Mapping not found for provided currencies");
		}
		currencyMapping.get().setPort(serverPort);
		return ResponseEntity.ok(new SuccessResponse<>(null, currencyMapping.get()));
	}

}
