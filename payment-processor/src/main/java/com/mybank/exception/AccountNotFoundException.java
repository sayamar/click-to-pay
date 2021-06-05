package com.mybank.exception;

public class AccountNotFoundException extends RuntimeException {
	
	public AccountNotFoundException(String errMsg) {
		super(errMsg);
	}

}
