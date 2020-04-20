package org.code4cause.microservices.currencyexchangeservice.web.rest;

import org.code4cause.microservices.currencyexchangeservice.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFoundExceptionHandler(final ResourceNotFoundException exception) {
		final String errorMssage = exception.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(errorMssage);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
}
