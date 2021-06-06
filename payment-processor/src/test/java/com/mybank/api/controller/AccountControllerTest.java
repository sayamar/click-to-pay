package com.mybank.api.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import com.mybank.data.entities.Account;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
	
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void getBalance() throws URISyntaxException {
		String accountId = "200";
		final String accountBalanceUrl = "http://localhost:8083/sandbox/v2/accounts/"+accountId+"/balances";
		URI uri = new URI(accountBalanceUrl);
		
		ResponseEntity<Account> result=  this.restTemplate.getForEntity(uri, Account.class);
	
		org.junit.Assert.assertEquals("1000.0", String.valueOf(result.getBody().getBalance()));
	}

}
