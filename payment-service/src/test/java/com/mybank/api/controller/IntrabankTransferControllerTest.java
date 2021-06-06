package com.mybank.api.controller;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.mybank.api.response.PaymentResponse;
import com.mybank.intrabank.model.FundTransferDetl;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntrabankTransferControllerTest {

	@LocalServerPort
	int port;

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void transferToOwnAccounts() throws URISyntaxException {

		final String toOwnAccountUrl = "http://localhost:" + port + "/sandbox/api/sg/v2/transfers/toOwnAccounts";
		URI uri = new URI(toOwnAccountUrl);
		FundTransferDetl payment1 = new FundTransferDetl();
		payment1.setAmount(20);
		payment1.setDebitAccountId("200");
		payment1.setCreditAccountId("100");
		payment1.setDestinationCurrency("SGD");
		payment1.setPartyId("VARA");
		payment1.setReferenceId("TEST1");
		payment1.setSourceCurrency("SGD");
		payment1.setTransferCurrency("SGD");
		payment1.setValueDate("07-Jun-2021");

		// Adding header information
		HttpHeaders headers = new HttpHeaders();
		headers.add("clientId", "TATAMOTORS");

		HttpEntity<FundTransferDetl> transferRequest = new HttpEntity<>(payment1, headers);

		ResponseEntity<PaymentResponse> result = this.restTemplate.postForEntity(uri, transferRequest,
				PaymentResponse.class);
		assertSame(HttpStatus.OK, result.getStatusCode());

	}

}
