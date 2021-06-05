package com.mybank.data.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name ="Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tnxId;
	@Column
	private Long accounNumber;
	@Column
	private String transactionType;
	
	@Column
	private Double tnxAmunt;
	@Column
	private Timestamp createdOn;
	
	public Long getTnxId() {
		return tnxId;
	}
	public void setTnxId(Long tnxId) {
		this.tnxId = tnxId;
	}
	public Long getAccounNumber() {
		return accounNumber;
	}
	public void setAccounNumber(Long accounNumber) {
		this.accounNumber = accounNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	public Double getTnxAmunt() {
		return tnxAmunt;
	}
	public void setTnxAmunt(Double tnxAmunt) {
		this.tnxAmunt = tnxAmunt;
	}
	public Timestamp getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}
	
	

}
