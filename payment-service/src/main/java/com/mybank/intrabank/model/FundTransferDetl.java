package com.mybank.intrabank.model;

import com.sun.istack.NotNull;

public class FundTransferDetl {
	

	
	private String debitAccountId;
	private String creditAccountId;
	@NotNull
    private int amount;
    private String sourceCurrency;
    private String destinationCurrency;
    private String transferCurrency;
    private String valueDate;
    private String partyId;
    private String referenceId;
    
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
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	

}
