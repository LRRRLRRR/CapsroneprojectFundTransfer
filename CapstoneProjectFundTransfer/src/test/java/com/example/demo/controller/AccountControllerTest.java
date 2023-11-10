package com.example.demo.controller;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.service.AccountServiceImp;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountControllerTest.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private AccountServiceImp acc;
	
	
	
	@Test
	public void getAlltest() throws Exception{
		
		Customer c1= new Customer("Mounica", "Hyderabad");
				
				Customer c2= new Customer("Preethi","Medchal");
				
				
				c1.setCustomerId(20000L);
				c2.setCustomerId(20001L);
				
				Account a1= new Account("Savings", 20000);
				Account a2= new Account("Current", 60000);
				
				a1.setAccountNumber(4000L);
				a2.setAccountNumber(4001L);
				a1.setCustomer(c1);
				a2.setCustomer(c2);
				
				
				List<Account>  list= new ArrayList();
				list.add(a1);
				list.add(a2);
				when(acc.getAll()).thenReturn(list);
				
				RequestBuilder request=MockMvcRequestBuilders.get("/Accounts").accept(MediaType.APPLICATION_JSON);
				
				
				
				MvcResult result=mock.perform(request)
			              
				          .andExpect(content().json("[{\r\n"
				          		+ "    \"accountNumber\": 4000,\r\n"
				          		+ "    \"accountType\": \"Savings\",\r\n"
				          		+ "    \"balance\": 20000,\r\n"
				          		+ "    \"customer\": {\r\n"
				          		+ "        \"customerId\": 20000,\r\n"
				          		+ "        \"name\": \"Mounica\",\r\n"
				          		+ "        \"address\": \"Hyderabad\"\r\n"
				          		+ "    }\r\n"
				          		+ "},{\r\n"
				          		+ "    \"accountNumber\": 4001,\r\n"
				          		+ "    \"accountType\": \"Current\",\r\n"
				          		+ "    \"balance\": 60000,\r\n"
				          		+ "    \"customer\": {\r\n"
				          		+ "        \"customerId\": 20001,\r\n"
				          		+ "        \"name\": \"Preethi\",\r\n"
				          		+ "        \"address\": \"Medchal\"\r\n"
				          		+ "    }\r\n"
				          		+ "}]"))
				          .andReturn();
				
				
				
				
			}
	
	
	
	@Test
	public void addTest() throws Exception{
		
		RequestBuilder request=MockMvcRequestBuilders.post("/Accounts")
				.content(" {\r\n"
                		+ "       \r\n"
                		+ "        \"accountType\": \"Savings\",\r\n"
                		+ "        \"balance\": 60000,\r\n"
                		+ "        \"customer\": {\r\n"
                		+ "            \r\n"
                		+ "            \"name\": \"Anay\",\r\n"
                		+ "        \"address\": \"Rangareddy\",\r\n"
                		+ "        }\r\n"
                		+ "    }\r\n"
                		+ "")
				  .contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mock.perform(request)
	              .andReturn();

	
	
}

	
	@Test
	public void updateTest() throws Exception{
		
		RequestBuilder request=MockMvcRequestBuilders.put("/Accounts")
				
				                                               .content(" {\r\n"
				                                            		   + "       \r\n"
				                                            		   + "        \"accountType\": \"Savings\",\r\n"
							                                    		+ "        \"balance\": 60000,\r\n"
							                                    		+ "        \"customer\": {\r\n"
							                                    		+ "            \r\n"
							                                    		+ "            \"name\": \"Anay\",\r\n"
							                                    		+ "        \"address\": \"Rangareddy\",\r\n"
							                                    		+ "        }\r\n"
							                                    		+ "    }\r\n"
							                                    		+ "")
				                                               
				                                               .contentType(MediaType.APPLICATION_JSON);
		
	                                        	MvcResult result=mock.perform(request)
	                                                                    
	                                                                          .andReturn();
	}
	
	
	@Test
    
	public void deleteTest() throws Exception{
			
			RequestBuilder request=MockMvcRequestBuilders.delete("/Accounts/2");
					                                    
			MvcResult result=mock.perform(request)
					             
					              .andReturn();
		}
	
	@Test
	public void fingByIdTest() throws Exception{
		
		RequestBuilder request=MockMvcRequestBuilders.get("/Accounts/2");
				                                    
		MvcResult result=mock.perform(request)
				            
				              .andReturn();
		
		
		
	}	
	
}