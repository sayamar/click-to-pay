package com.mybank.service;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import org.springframework.stereotype.Service;

import com.mybank.data.entities.Transaction;
import com.mybank.data.repos.TransactionRepository;
import com.mybank.exception.EmptyTransactionList;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	private final TransactionRepository transactionRepo;
	
	public TransactionServiceImpl(TransactionRepository transactionRepo) {
		this.transactionRepo = transactionRepo;
	}

	@Override
	public List<Transaction> getAllTnxByAccountId(Long accountNumber) {
		
		List<Transaction> tnxList = this.transactionRepo.getAllTnxByAccountId(accountNumber)
				.stream().sorted(comparing(Transaction::getTnxId)).collect(toList());
				
		if (tnxList != null && tnxList.size() > 0) {
			return tnxList;
		}
		else {
			throw new EmptyTransactionList("No Transaction Available");
		}
		
	}

	@Override
	public Transaction getTnxById(Long TnxId) {
		return this.transactionRepo.findById(TnxId)
				.orElseThrow(() -> new EmptyTransactionList("Transaction Id not found"));
	}

}
