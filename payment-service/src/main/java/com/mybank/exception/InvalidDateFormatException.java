package com.mybank.exception;

public class InvalidDateFormatException extends RuntimeException{
	
	public InvalidDateFormatException(String errMsg) {
		super(errMsg);
	}

}
