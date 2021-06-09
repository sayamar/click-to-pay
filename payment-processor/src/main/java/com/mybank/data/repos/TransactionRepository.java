package com.mybank.data.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mybank.data.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	@Query(value ="select * from Transaction t where t.ACCOUNT_NUMBER =:accountNumber",nativeQuery = true)
	public List<Transaction> getAllTnxByAccountId(@Param("accountNumber") Long accountNumber);
}
