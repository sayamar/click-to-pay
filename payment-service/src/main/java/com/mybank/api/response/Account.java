package com.mybank.api.response;


public class Account {
	
	private Long accnumber;
	private String customername;
	private int pin_code;
	private Double balance;
	private Double limit_amount;
	private String accountType;
	public Long getAccnumber() {
		return accnumber;
	}
	public void setAccnumber(Long accnumber) {
		this.accnumber = accnumber;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getPin_code() {
		return pin_code;
	}
	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getLimit_amount() {
		return limit_amount;
	}
	public void setLimit_amount(Double limit_amount) {
		this.limit_amount = limit_amount;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	

}
