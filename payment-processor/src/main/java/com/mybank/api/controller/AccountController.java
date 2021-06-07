package com.mybank.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.data.entities.Account;
import com.mybank.data.entities.Transaction;
import com.mybank.exception.AccountNotFoundException;
import com.mybank.service.PaymentService;

@RestController
@RequestMapping("/sandbox/v2/accounts/")
public class AccountController {
	
	private static final Logger log = LoggerFactory.getLogger(AccountController.class);
	
	private final PaymentService paymentService;
	
	@Autowired
	public AccountController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	@GetMapping("{accountId}/balance")
	public ResponseEntity<Account> getBalance(@PathVariable("accountId") Long accountId){
		log.info("Get Balance for {}", accountId);
		Account accountBalance = this.paymentService.getBalance(accountId);
		return new ResponseEntity<Account>(accountBalance, HttpStatus.OK);
	}
	
	@GetMapping("{accountId}/allTnxList")
	public ResponseEntity<List<Transaction>> getAllTnxByAccountId(){
		List<Transaction> tnxList = null;
		return new ResponseEntity<>(tnxList,HttpStatus.OK);
	}
	
	@GetMapping("{accountId}/{tnxId}")
	public ResponseEntity<Transaction> getTnxByAccountId(){
		Transaction tnx= null;
		return new ResponseEntity<>(tnx,HttpStatus.OK);
		
	}
	@GetMapping("{accountId}/inRange")
	public ResponseEntity<List<Transaction>> getTnxListInDateRange(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate){
		List<Transaction> tnxList = null;
		return new ResponseEntity<>(tnxList,HttpStatus.OK);
		
	}

}
