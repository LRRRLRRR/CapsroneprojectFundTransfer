package com.example.demo.dao;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Account;



@DataJpaTest
@RunWith(SpringRunner.class)
public class AccountJpaRepositoryTest {
	
	@Autowired
	private AccountJpaRepository repo;
	
	@Test
	public void findAllTest() {
		
		List <Account> a =repo.findAll();
		assertEquals(0,a.size());
		
	}

}
