package com.mybank.api.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.api.response.PaymentResponse;
import com.mybank.intrabank.model.AccountCheck;
import com.mybank.intrabank.model.AdhocTransfer;
import com.mybank.intrabank.model.FundTranferPayeeDetl;
import com.mybank.intrabank.model.FundTransferDetl;
import com.mybank.intrabank.model.TransactionReversal;
import com.mybank.service.PaymentService;

@RestController
@RequestMapping("/sandbox/api/sg/v2/")
public class IntrabankTranferController {
	
	private static final Logger log = LoggerFactory.getLogger(IntrabankTranferController.class);

	
	private final PaymentService paymentService;
	
	@Autowired
	public IntrabankTranferController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping(path=" /transfers/toOwnAccounts")
	public ResponseEntity<PaymentResponse> toOwnAccounts(@RequestHeader Map<String, String> header,
			@RequestBody FundTransferDetl payload) {
		log.info("Start: toOwnAccounts"+payload.getReferenceId());
		PaymentResponse response = this.paymentService.toOwnAccounts(payload);
		return new ResponseEntity<PaymentResponse>(response, HttpStatus.OK);
	}
	
	@PostMapping(path=" /transfers/creditPayeeAccount")
	public ResponseEntity<PaymentResponse> creditPayeeAccount(@RequestHeader Map<String, String> header,
			@RequestBody FundTranferPayeeDetl payload) {
		log.info("Start: adhocTransfer"+payload.referenceId);
		return new ResponseEntity<PaymentResponse>(new PaymentResponse("IBXRTRR","Success"), HttpStatus.OK);
	}
	
	@PostMapping(path="/transfers/adhocTransfer")
	public ResponseEntity<PaymentResponse> adhocTransfer(@RequestHeader Map<String, String> header,
			@RequestBody AdhocTransfer payload) {
		log.info("Start: adhocTransfer"+payload.referenceId);
		return new ResponseEntity<PaymentResponse>(new PaymentResponse("IBXRTRR","Success"), HttpStatus.OK);
	}
	
	@GetMapping(path=" /transfers/{referenceId}/status")
	public ResponseEntity<PaymentResponse> getFundTranferStatus(@RequestHeader Map<String, String> header,
			@PathVariable("referenceId") String  referenceId, @RequestParam String accountId) {
		log.info("Start: adhocTransfer"+referenceId);
		return new ResponseEntity<PaymentResponse>(new PaymentResponse("IBXRTRR","Success"), HttpStatus.OK);
	} 
	
	@GetMapping(path=" /transfers/{referenceId}/reversal")
	public ResponseEntity<PaymentResponse> getFundTranferStatus(@RequestHeader Map<String, String> header,
			@PathVariable("referenceId") String  referenceId, @RequestBody TransactionReversal payload) {
		log.info("Start: adhocTransfer"+referenceId);
		return new ResponseEntity<PaymentResponse>(new PaymentResponse("IBXRTRR","Success"), HttpStatus.OK);
	}
	
	
	
	
	

}
