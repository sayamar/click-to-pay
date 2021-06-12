package com.mybank.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.api.response.PaymentResponse;
import com.mybank.data.entities.TransferHistory;
import com.mybank.exception.FundTransferException;
import com.mybank.model.FundTransferDetl;
import com.mybank.service.PaymentService;

@RestController
@RequestMapping("/process")
public class IntraBankProcessor {
	
	private static final Logger log = LoggerFactory.getLogger(IntraBankProcessor.class);

	private final PaymentService paymentService;

	public IntraBankProcessor(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@ExceptionHandler(FundTransferException.class)
	@PostMapping("/initiateTransfer")
	public PaymentResponse initiateTransfer(@RequestBody FundTransferDetl payload) {
		log.info("Inititate transfer for {}", payload.getReferenceId());
		TransferHistory transferHist = paymentService.toOwnAccounts(payload);
		return PaymentResponse.createPaymentresponse(transferHist);

	}

}
