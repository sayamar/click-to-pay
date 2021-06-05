package com.mybank.service;

import com.mybank.api.response.PaymentResponse;
import com.mybank.intrabank.model.AdhocTransfer;
import com.mybank.intrabank.model.FundTranferPayeeDetl;
import com.mybank.intrabank.model.FundTransferDetl;
import com.mybank.intrabank.model.FundTransferStatus;
import com.mybank.intrabank.model.TransactionReversal;

public interface PaymentService {
	
	public PaymentResponse toOwnAccounts(FundTransferDetl payload) ;
	public PaymentResponse creditPayeeAccount(FundTranferPayeeDetl payload) ;
	public PaymentResponse adhocTransfer(AdhocTransfer  payload);
	public PaymentResponse getFundTransferStatus( FundTransferStatus payload);
	public PaymentResponse initiateReversal(TransactionReversal tnxReversal);

}
