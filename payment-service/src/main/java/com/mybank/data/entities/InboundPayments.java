package com.mybank.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="inbound_payments")
public class InboundPayments {
	
	@Id
	private String referenceId;
	@Column
	private String debitAccountId;
	@Column
	private String creditAccountId;
	@NotNull
    private int amount;
	@Column
    private String sourceCurrency;
	@Column
    private String destinationCurrency;
	@Column
    private String transferCurrency;
	@Column
    private String valueDate;
	@Column
    private String partyId;
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getDebitAccountId() {
		return debitAccountId;
	}
	public void setDebitAccountId(String debitAccountId) {
		this.debitAccountId = debitAccountId;
	}
	public String getCreditAccountId() {
		return creditAccountId;
	}
	public void setCreditAccountId(String creditAccountId) {
		this.creditAccountId = creditAccountId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public String getDestinationCurrency() {
		return destinationCurrency;
	}
	public void setDestinationCurrency(String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}
	public String getTransferCurrency() {
		return transferCurrency;
	}
	public void setTransferCurrency(String transferCurrency) {
		this.transferCurrency = transferCurrency;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public String getPartyId() {
		return partyId;
	}
	public void setPartyId(String partyId) {
		this.partyId = partyId;
	}
    
	
    
}
