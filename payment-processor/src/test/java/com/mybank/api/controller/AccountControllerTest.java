package com.mybank.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.mybank.data.entities.Account;
import com.mybank.data.entities.Transaction;

import junit.framework.Assert;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
	
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void getBalance() throws URISyntaxException {
		final String  accountId = "200";
		final String accountBalanceUrl = "http://localhost:"+port+"/sandbox/v2/accounts/"+accountId+"/balance";
		URI uri = new URI(accountBalanceUrl);
		
		ResponseEntity<Account> result=  this.restTemplate.getForEntity(uri, Account.class);
		org.junit.Assert.assertEquals("1000.0", String.valueOf(result.getBody().getBalance()));
	}
	
	void getTnxList() throws URISyntaxException {
		final String accountId="200";
		final String tnxListUrl = "http://localhost:"+port+"/sandbox/v2/accounts/"+accountId+"/tnxlist";
		URI uri = new URI(tnxListUrl);
		
		ResponseEntity<List<Transaction>> tnxList =
				this.restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<Transaction>>() {});
		tnxList.getBody().forEach(w -> System.out.println(w.getTnxAmunt()));
		org.junit.Assert.assertEquals(HttpStatus.OK, tnxList.getStatusCode());
	}

}
