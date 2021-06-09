package com.mybank.api.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
import com.mybank.exception.EmptyTransactionList;
import com.mybank.service.PaymentService;
import com.mybank.service.TransactionService;

@RestController
@RequestMapping("/sandbox/v2/accounts/")
public class AccountController {

	private static final Logger log = LoggerFactory.getLogger(AccountController.class);

	private final PaymentService paymentService;

	private final TransactionService transactionService;

	@Autowired
	public AccountController(PaymentService paymentService, TransactionService transactionService) {
		this.paymentService = paymentService;
		this.transactionService = transactionService;
	}

	@ExceptionHandler(AccountNotFoundException.class)
	@GetMapping(path = "{accountId}/balance" )
	public ResponseEntity<Account> getBalance(@PathVariable("accountId") Long accountId) throws Exception {
		log.info("Get Balance for {}", accountId);

		CompletableFuture<Account> future = 
				CompletableFuture.supplyAsync(() -> this.processString(accountId));
		Account account = future.get();
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}

	@ExceptionHandler(EmptyTransactionList.class)
	@GetMapping(path = "{accountId}/tnxlist" )
	public ResponseEntity<List<Transaction>> getAllTnxByAccountId(@PathVariable() Long accountId) throws Exception {
		log.info("GET tnxList {} for ", accountId);
		
		CompletableFuture<List<Transaction>> tnxListFuture = CompletableFuture
				.supplyAsync(() -> this.getTnxListByAccountId(accountId));
		List<Transaction> tnxList = tnxListFuture.get();
		return new ResponseEntity<>(tnxList, HttpStatus.OK);
	}
	
	@GetMapping(path ="{accountId}/{tnxId}" )
	public ResponseEntity<Transaction> getTnxByAccountId(@PathVariable("accountId") Long accountId) throws Exception{
		log.info("GET tnxDetails {} for ", accountId);
		CompletableFuture<Transaction> tnxFuture = 
				CompletableFuture.supplyAsync( () -> this.getTnxDetlById(accountId));
		Transaction tnxData = tnxFuture.get();
		return new ResponseEntity<>(tnxData, HttpStatus.OK);

	}

	@GetMapping("{accountId}/inRange")
	public ResponseEntity<List<Transaction>> getTnxListInDateRange(@RequestParam("fromDate") String fromDate,
			@RequestParam("toDate") String toDate) {
		List<Transaction> tnxList = null;
		return new ResponseEntity<>(tnxList, HttpStatus.OK);

	}

	/**
	 * To process the request Asynchronously
	 * 
	 * @param accid
	 * @return
	 */
	private Account processString(Long accountId) {
		return this.paymentService.getBalance(accountId);

	}

	private List<Transaction> getTnxListByAccountId(Long accountId) {
		return this.transactionService.getAllTnxByAccountId(accountId);
	}
	
	private Transaction getTnxDetlById(Long tnxId) {
		return this.transactionService.getTnxById(tnxId);
	}

}
