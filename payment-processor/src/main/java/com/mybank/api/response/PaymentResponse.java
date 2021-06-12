package com.mybank.api.response;

import com.mybank.data.entities.TransferHistory;

public class PaymentResponse {
	
	 public String referenceId;
	 public String status;
	 
	public PaymentResponse() {
		super();
	}
	public PaymentResponse(String referenceId, String status) {
		super();
		this.referenceId = referenceId;
		this.status = status;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static PaymentResponse createPaymentresponse(TransferHistory history) {
		PaymentResponse paymentResponse = new PaymentResponse();
		paymentResponse.setReferenceId(history.getPaymentRefId());
		paymentResponse.setStatus(history.getStatus());
		return paymentResponse;
	}
	 
	 


	
	

}
