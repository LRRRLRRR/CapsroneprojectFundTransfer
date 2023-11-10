package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AccountJpaRepository;
import com.example.demo.dao.CustomerJpaRepository;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.exception.AccountNotFoundException;


import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImp {
@Autowired
private AccountJpaRepository repo;

@Autowired
private CustomerJpaRepository repo1;

public List<Account> getAll(){
return repo.findAll();
}
public Account findById(long Id) {
Optional <Account> result=repo.findById(Id);
Account e =null;
if(result.isPresent())
e=result.get();
else
throw new AccountNotFoundException("Account id not found" +Id);
return e;
}

//public Account findBycustId(long Id) {
//Optional <Account> result=repo.findById(Id);
//Account e =null;
//if(result.isPresent())
//e=result.get();
//else
//throw new AccountNotFoundException("Customer id not found" +Id);
//return e;
//}



public Account save(Account theAccount) {
String name=theAccount.getCustomer().getName();
Customer c1=repo1.findByName(name);
if(c1!=null)
throw new RuntimeException( "Customer already exists");
return repo.save(theAccount);
}

public Account update(Account theAccount) {
return repo.save(theAccount);
}

public void deleteById(Long id) {
if(repo.findById(id).isPresent())
repo.deleteById(id);
else
throw new AccountNotFoundException("Account id not exists" +id);
}



public void deleteAll() {
repo.deleteAll();
}

public String transferFund(Long from, Long to, int amount) {
Optional<Account>c1=repo.findById(from);
Optional<Account>c2=repo.findById(to);
if(from==to)
	return "From and To account cannot be same";
if(c1.isPresent())
{
	if(c2.isPresent()) {
		Account a1=c1.get();
		Account a2=c2.get();
		int b1From=a1.getBalance();
		int b2To=a2.getBalance();
		if(b1From>=amount)
		{
			a1.setBalance(b1From-amount);
			a2.setBalance(b2To+amount);
			repo.save(a1);
			repo.save(a2);
			return "transfer Successfull";
		}
		else
			return "insufficient balance";
		
	}
	else
		return "to account not exist";
}
else
	 return "From account not present";

}

 public List<Account> findByAccounttype(String accountType){
return repo.findByAccountType(accountType);
}
 
 
 
 
}