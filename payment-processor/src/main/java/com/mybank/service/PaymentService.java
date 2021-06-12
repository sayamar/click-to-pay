package com.mybank.service;

import com.mybank.data.entities.Account;
import com.mybank.data.entities.TransferHistory;
import com.mybank.model.FundTransferDetl;

public interface PaymentService {
	
	public TransferHistory toOwnAccounts(FundTransferDetl payload);
	public Account getBalance(Long accountId);
	

}
