package com.example.demo.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Account;



public interface AccountJpaRepository extends JpaRepository<Account, Long> {
	
	
	@Query("SELECT a from Account a where a.accountType=:accountType")
			
List<Account> findByAccountType(String accountType);
}
