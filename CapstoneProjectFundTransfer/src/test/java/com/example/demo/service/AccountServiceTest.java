package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.dao.AccountJpaRepository;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;



@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	
	@InjectMocks
	AccountServiceImp accountService;
	
	
	@Mock
	AccountJpaRepository repo;
	
	@Test
	public void gtAllService() {
		
		
		Customer c1= new Customer("Mounica", "Hyderabad");
		
		Customer c2= new Customer("Preethi","Medchal");
		
		
		c1.setCustomerId(2000L);
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
		when(repo.findAll()).thenReturn(list);
		List<Account> a= accountService.getAll();
		assertEquals(5,a.size());
		verify(repo,times(1)).findAll();
		
		
	}
	
	public void findByIdTest()
	{
		
		
		Customer c1= new Customer("Mounica", "Hyderabad");
		
		c1.setCustomerId(2000L);
		Account a1= new Account("Savings", 20000);
		a1.setAccountNumber(4000L);
		a1.setCustomer(c1);
		Account a= accountService.findById(4000);
	}
	
	@Test
	public void addTest() {
      Customer c1= new Customer("Mounica", "Hyderabad");
		
		c1.setCustomerId(2000L);
		Account a1= new Account("Savings", 20000);
		a1.setAccountNumber(4000L);
		a1.setCustomer(c1);
		accountService.save(a1);
		verify(repo,times(1)).save(a1);
		
		
	}
	
	@Test
	public void deleteTest() {
		
		
		accountService.deleteById(4000L);
		verify(repo,times(1)).deleteById(4000L);
		
	}
	
	

}
