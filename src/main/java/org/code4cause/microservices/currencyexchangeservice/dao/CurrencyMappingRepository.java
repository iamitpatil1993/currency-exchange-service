package org.code4cause.microservices.currencyexchangeservice.dao;

import java.util.Optional;

import org.code4cause.microservices.currencyexchangeservice.model.CurrencyMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyMappingRepository extends JpaRepository<CurrencyMapping, Long> {

	Optional<CurrencyMapping> findByFromCurrencyAndToCurrency(final String fromCurrency, final String toCurrency);
}
