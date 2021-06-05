package com.mybank.data.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mybank.data.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
