/**
 * 
 */
package com.mybank.data.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author HP
 *
 */
@Entity
@Table(name ="TRANSFER_HISTORY")
public class TransferHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transferId;
	private Long debitorId;
	private Long creditorId;
	private String status;
	private Integer quantity;
	private String paymentRefId;
	private Timestamp tranferredOn;
	public Long getTransferId() {
		return transferId;
	}
	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}
	public Long getDebitorId() {
		return debitorId;
	}
	public void setDebitorId(Long debitorId) {
		this.debitorId = debitorId;
	}
	public Long getCreditorId() {
		return creditorId;
	}
	public void setCreditorId(Long creditorId) {
		this.creditorId = creditorId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getPaymentRefId() {
		return paymentRefId;
	}
	public void setPaymentRefId(String paymentRefId) {
		this.paymentRefId = paymentRefId;
	}
	public Timestamp getTranferredOn() {
		return tranferredOn;
	}
	public void setTranferredOn(Timestamp tranferredOn) {
		this.tranferredOn = tranferredOn;
	}
	
	
	
	

}
