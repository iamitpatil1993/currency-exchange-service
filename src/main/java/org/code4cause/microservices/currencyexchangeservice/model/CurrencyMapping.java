package org.code4cause.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "currency_mapping")
public class CurrencyMapping {

	@Id
	@Basic
	@Column(name = "id")
	private Long id;

	@Basic
	@Column(name = "from_currency")
	private String fromCurrency;

	@Basic
	@Column(name = "to_currency")
	private String toCurrency;

	@Basic
	@Column(name = "conversion_factor")
	private BigDecimal conversionFactor;

	@Basic
	@Column(name = "is_deleted")
	@JsonIgnore
	private boolean isDeleted;

	@Basic
	@Column(name = "created_on")
	private Instant createdOn;

	@Basic
	@Column(name = "updated_on")
	private Instant updatedOn;
	
	@Transient
	private int port;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conversionFactor == null) ? 0 : conversionFactor.hashCode());
		result = prime * result + ((fromCurrency == null) ? 0 : fromCurrency.hashCode());
		result = prime * result + ((toCurrency == null) ? 0 : toCurrency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyMapping other = (CurrencyMapping) obj;
		if (conversionFactor == null) {
			if (other.conversionFactor != null)
				return false;
		} else if (!conversionFactor.equals(other.conversionFactor))
			return false;
		if (fromCurrency == null) {
			if (other.fromCurrency != null)
				return false;
		} else if (!fromCurrency.equals(other.fromCurrency))
			return false;
		if (toCurrency == null) {
			if (other.toCurrency != null)
				return false;
		} else if (!toCurrency.equals(other.toCurrency))
			return false;
		return true;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
