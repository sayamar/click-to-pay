package com.mybank.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybank.data.entities.Account;
import com.mybank.exception.AccountNotFoundException;
import com.mybank.service.PaymentService;

@RestController
@RequestMapping("/sandbox/v2/accounts")
public class AccountController {
	
	private final PaymentService paymentService;
	
	public AccountController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	@GetMapping("/{accountId}/balances")
	public ResponseEntity<Account> getBalance(@PathVariable("accountId") Long accountId){
		return new ResponseEntity<Account>(this.paymentService.getBalance(accountId), HttpStatus.OK);
	}

}
