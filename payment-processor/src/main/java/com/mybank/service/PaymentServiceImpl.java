package com.mybank.service;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybank.api.response.PaymentResponse;
import com.mybank.data.entities.Account;
import com.mybank.data.entities.Transaction;
import com.mybank.data.repos.AccountRepository;
import com.mybank.data.repos.TransactionRepository;
import com.mybank.exception.AccountNotFoundException;
import com.mybank.exception.OverDraftException;
import com.mybank.model.FundTransferDetl;
import com.mybank.service.handlers.TransactionHandler;

@Service
public class PaymentServiceImpl implements PaymentService {

	private static final Logger log = LoggerFactory.getLogger(PaymentServiceImpl.class); 
	
	private final AccountRepository accountRepository;
	private final TransactionRepository transRepository;
	private final TransactionHandler tnxHandler;

	@Autowired
	public PaymentServiceImpl(AccountRepository accountRepository, TransactionRepository transRepository,
			TransactionHandler tnxHandler) {
		this.accountRepository = accountRepository;
		this.transRepository = transRepository;
		this.tnxHandler = tnxHandler;

	}

	@Override
	public PaymentResponse toOwnAccounts(FundTransferDetl payload) {
		log.info("Initiate Funds transfer {} to ", payload.getCreditAccountId());
		createTrannsactionsList(payload);
		tranferringBalance(payload);
		return PaymentResponse.createPaymentresponse(payload, "Success");

	}

	@Override
	public Account getBalance(Long accountId) {
		Account account = this.accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account id: " + accountId + " not found "));
		return account;
	}

	/**
	 * Amount debit and credit happens at account Level
	 * 
	 * @param payload
	 */
	private void tranferringBalance(FundTransferDetl payload) {

		log.info("Transferring the balance {} ", payload.getDebitAccountId(),payload.getCreditAccountId());
		Account debitAccount = this.accountRepository.getAccountForUpdate(Long.valueOf(payload.getDebitAccountId()))
				.orElseThrow(() -> new AccountNotFoundException(
						"Debit Account : " + Long.valueOf(payload.getDebitAccountId()) + " Not exist"));

		Account creditAccount = this.accountRepository.getAccountForUpdate(Long.valueOf(payload.getCreditAccountId()))
				.orElseThrow(() -> new AccountNotFoundException(
						"Creditor Account : " + Long.valueOf(payload.getCreditAccountId()) + " Not exist"));

		if (debitAccount.getBalance().compareTo(new Double(payload.getAmount())) < 0) {
			throw new OverDraftException(
					"Account id: " + debitAccount.getAccnumber() + " does not have enough balance to transfer",
					"ERR_CLIENT_001");
		}
		
		if (debitAccount.getLimit_amount().compareTo(new Double(payload.getAmount())) < 0) {
			throw new OverDraftException(
					"Account id: " + debitAccount.getAccnumber() + " exceeds the limit for the day",
					"ERR_CLIENT_001");
		}

		debitAccount.setBalance(this.tnxHandler.debitAccount(new Double(payload.getAmount()), debitAccount));
		this.accountRepository.saveAndFlush(debitAccount);

		// Crediting into Beneficiary Account

		creditAccount.setBalance(this.tnxHandler.creditAccount(new Double(payload.getAmount()), creditAccount));
		this.accountRepository.saveAndFlush(creditAccount);

	}

	/**
	 * created the trasnaction for each account
	 * 
	 * @param payload
	 * @param accList
	 */
	private void createTrannsactionsList(FundTransferDetl payload) {
		log.info("Creating the debit transaction for {}", payload.getDebitAccountId());
		Transaction tnxForDebit = new Transaction();
		Transaction tnxForCredit = new Transaction();

		tnxForDebit.setAccounNumber(Long.valueOf(payload.getDebitAccountId()));
		tnxForDebit.setTransactionType("Debit");
		tnxForDebit.setTnxAmunt(new Double(payload.getAmount()));
		tnxForDebit.setCreatedOn(getToday());

		this.transRepository.save(tnxForDebit);
		log.info("Creating the credit transaction for {}", payload.getDebitAccountId());
		tnxForCredit.setAccounNumber(Long.valueOf(payload.getCreditAccountId()));
		tnxForCredit.setTransactionType("Credit");
		tnxForCredit.setTnxAmunt(new Double(payload.getAmount()));
		tnxForCredit.setCreatedOn(getToday());

		this.transRepository.save(tnxForCredit);

	}

	private boolean isHoliday() {
		return true;
	}

	private boolean isCutOffOver() {
		return true;
	}

	private boolean gateWayAvailability() {
		return true;
	}

	private Timestamp getToday() {
		return new Timestamp(System.currentTimeMillis());
	}

}
