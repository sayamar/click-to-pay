package com.mybank.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.api.config.PaymentProcessorFeignConfig;
import com.mybank.api.response.PaymentResponse;
import com.mybank.data.entities.InboundPayments;
import com.mybank.data.repos.PaymentInboundRepository;
import com.mybank.intrabank.model.AdhocTransfer;
import com.mybank.intrabank.model.FundTranferPayeeDetl;
import com.mybank.intrabank.model.FundTransferDetl;
import com.mybank.intrabank.model.FundTransferStatus;
import com.mybank.intrabank.model.TransactionReversal;
import com.mybank.mapper.PaymentInboundMapper;

@Service
public class PaymentServiceImpl implements PaymentService {

	private final PaymentProcessorFeignConfig paymentFeignClient;

	private final PaymentInboundRepository paymentsInboundRepo;

	@Autowired
	public PaymentServiceImpl(PaymentProcessorFeignConfig paymentFeignClient,
			PaymentInboundRepository paymentsInboundRepo) {

		this.paymentFeignClient = paymentFeignClient;
		this.paymentsInboundRepo = paymentsInboundRepo;
	}

	@Override
	public PaymentResponse toOwnAccounts(FundTransferDetl payload) {

		if (valueDateCheck(payload.getValueDate())) {
			/** Register the inbound payment in system incase of any re-processs*/
			this.paymentsInboundRepo.saveAndFlush(createInboundPaymentRecord(payload));
			
			PaymentResponse response = this.paymentFeignClient.initiateTransfer(payload);
			
			/** Update the payment status in inbound payments register*/
			
			return response;
		}
		return new PaymentResponse("", "Backed value date");
	}

	
	
	private InboundPayments createInboundPaymentRecord(FundTransferDetl payload) {
		return PaymentInboundMapper.INSTACE.fundTrasnferDetlToInboundPayments(payload);
	}

	@Override
	public PaymentResponse creditPayeeAccount(FundTranferPayeeDetl payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentResponse adhocTransfer(AdhocTransfer payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentResponse getFundTransferStatus(FundTransferStatus payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentResponse initiateReversal(TransactionReversal tnxReversal) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param valueDate
	 * @return
	 */
	private static boolean valueDateCheck(final String valueDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		int decider = 0;
		try {

			decider = formatter.parse(valueDate).compareTo(new Date());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Date format is invalid");
		}
		if (decider > 0 || decider == 0)
			return true;
		else
			return false;
	}

}
