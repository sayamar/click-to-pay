package com.mybank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestPointExceptionHandler {
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
	@ExceptionHandler(value = { FundTransferException.class })
	protected ResponseEntity<Object> handleIfFundsNotAvailable(
			FundTransferException ex, WebRequest request) {
		String error = "Funds transfer failed: " + ex.getMessage();
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
	}
	
	@ExceptionHandler(value = { AccountNotFoundException.class })
	protected ResponseEntity<Object> handleIfAccountIsNotFound(
			FundTransferException ex, WebRequest request) {
		String error = "Account not found: " + ex.getMessage();
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
	}
	
	@ExceptionHandler(value = { OverDraftException.class })
	protected ResponseEntity<Object> handleIfOverDraft(
			OverDraftException ex, WebRequest request) {
		String error = "Insufficient Funds " + ex.getMessage();
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
	}
	
	@ExceptionHandler(value = { EmptyTransactionList.class })
	protected ResponseEntity<Object> handleIfOverDraft(
			EmptyTransactionList ex, WebRequest request) {
		String error = "At present  " + ex.getMessage();
		return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, error, ex));
	}

}
