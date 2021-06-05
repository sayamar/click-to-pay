package com.mybank.exception;

public class FundTransferException extends RuntimeException{
	
	public FundTransferException(String errMsg) {
		super(errMsg);
	}

}
