package com.mybank.service.handlers;

import org.springframework.stereotype.Component;

import com.mybank.data.entities.Account;

@Component
public class TransactionHandler {
	
	public synchronized Double debitAccount( Double tnxAmount, Account account) {
		Double currentBalance = getBalance(account);
		currentBalance -= tnxAmount;
		return currentBalance;
	}
	
	public Double creditAccount( Double tnxAmount, Account account) {
		Double currentBalance = getBalance(account);
		currentBalance += tnxAmount;
		return currentBalance;
	}
	
	private Double getBalance(Account account) {
		return account.getBalance();
	}

}
