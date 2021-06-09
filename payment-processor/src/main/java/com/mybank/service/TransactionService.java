/**
 * 
 */
package com.mybank.service;

import java.util.List;

import com.mybank.data.entities.Transaction;

/**
 * @author HP
 *
 */
public interface TransactionService {
	
	
	public List<Transaction> getAllTnxByAccountId(Long accountId);
	public Transaction getTnxById(Long TnxId);

}
