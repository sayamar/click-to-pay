package com.mybank.api.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.api.response.PaymentResponse;
import com.mybank.exception.FundTransferException;
import com.mybank.model.FundTransferDetl;
import com.mybank.service.PaymentService;

@RestController
@RequestMapping("/process")
public class IntraBankProcessor {

	private final PaymentService paymentService;

	public IntraBankProcessor(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@ExceptionHandler(FundTransferException.class)
	@PostMapping("/initiateTransfer")
	public PaymentResponse initiateTransfer(@RequestBody FundTransferDetl payload) {
		System.out.println("Inside initiateTransfer"+payload.getReferenceId());
		return paymentService.toOwnAccounts(payload);

	}

}
