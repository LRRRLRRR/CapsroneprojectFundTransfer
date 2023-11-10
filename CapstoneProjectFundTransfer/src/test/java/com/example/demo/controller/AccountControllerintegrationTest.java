package com.example.demo.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AccountControllerintegrationTest {
	
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void  test() throws JSONException{
		
		String result=this.restTemplate.getForObject("/Accounts", String.class);
		                           JSONAssert.assertEquals(result,result,false);
	}
	

}
