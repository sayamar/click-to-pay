package com.mybank.api.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mybank.api.response.PaymentResponse;
import com.mybank.intrabank.model.FundTransferDetl;
/**
 * Use of Feign client
 * 1) A declarative REST client for Spring boot apps
 * 2) Feign  makes writing web service clients easier with pluggable annoation support
 * 3) A great thing about Feign client is, we don't have to write any code for calling the service, other than interface definition
 * @author HP
 *
 */

@FeignClient(name ="process", url="http://localhost:8083/", configuration = EnableFiegnClientConfig.class)
public interface PaymentProcessorFeignConfig {
	
	@PostMapping("/process/initiateTransfer")
	public PaymentResponse initiateTransfer(@RequestBody FundTransferDetl payload);

}
