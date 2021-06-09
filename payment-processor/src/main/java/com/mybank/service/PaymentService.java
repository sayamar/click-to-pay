package com.mybank.service;

import com.mybank.api.response.PaymentResponse;
import com.mybank.data.entities.Account;
import com.mybank.model.FundTransferDetl;

public interface PaymentService {
	
	public PaymentResponse toOwnAccounts(FundTransferDetl payload);
	public Account getBalance(Long accountId);
	

}
