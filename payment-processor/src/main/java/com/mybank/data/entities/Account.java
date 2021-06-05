/**
 * 
 */
package com.mybank.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Maruthi
 *
 */
@Entity
@Table (name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accnumber;
	@Column
	
	private String customername;
	@Column
	
	private int pin_code;
	@Column
	
	private Double balance;
	@Column
	
	private Double limit_amount;
	
	@Column
	private String accountType;
	
	@Column
	private String partyId;
	
	
	
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
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
	
	
	
	
	
		
	
}
