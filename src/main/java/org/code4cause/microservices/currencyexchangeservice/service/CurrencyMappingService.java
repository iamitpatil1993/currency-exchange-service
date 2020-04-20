package org.code4cause.microservices.currencyexchangeservice.service;

import java.util.Optional;

import org.code4cause.microservices.currencyexchangeservice.dao.CurrencyMappingRepository;
import org.code4cause.microservices.currencyexchangeservice.model.CurrencyMapping;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CurrencyMappingService {

	private CurrencyMappingRepository currencyMappingRepository;

	@Transactional(readOnly = true)
	public Optional<CurrencyMapping> findByFromAndToCurrnecy(final String fromCurrency, final String toCurrency) {
		return currencyMappingRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
	}

}
