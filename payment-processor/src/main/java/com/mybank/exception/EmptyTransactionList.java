package com.mybank.exception;

public class EmptyTransactionList extends RuntimeException {
	
   public EmptyTransactionList(String errMsg) {
	   super(errMsg);
   }

}
