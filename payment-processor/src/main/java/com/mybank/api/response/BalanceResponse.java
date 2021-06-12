package com.mybank.api.response;

public class BalanceResponse {
	
	private final Long accountNumber;
	private final Double balance;
	
	
	public BalanceResponse(Long accountNumber, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public Double getBalance() {
		return balance;
	}
	
	

}
