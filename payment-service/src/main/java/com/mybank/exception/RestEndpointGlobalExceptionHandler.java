package com.mybank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestEndpointGlobalExceptionHandler {
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@ExceptionHandler(value = { InvalidDateFormatException.class })
	protected ResponseEntity<Object> handleIfFundsNotAvailable(
			InvalidDateFormatException ex, WebRequest request) {
		String error = "Invalid Date: " + ex.getMessage();
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	}

}
