package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountServiceImp;


@RestController
public class AccountController {
	
	@Autowired
	private AccountServiceImp accountService;

	@GetMapping("/Accounts")
public List<Account> getAll()
{
	return accountService.getAll();

}
	
	@PostMapping("/Accounts")
	public Account add(@RequestBody Account theAccount) {
		
		return accountService.save(theAccount);
		
	}
	@GetMapping("/Accounts/{id}")
	public Account getAccount(@PathVariable Long id)
	{
		Account a=accountService.findById(id);
		return a;
	}
	
	
	@GetMapping("/Account/{accountType}")
	public List<Account> getAccountType(@PathVariable String accountType){
		return accountService.findByAccounttype(accountType);
		
	}
	
	
	
	@PutMapping("/Accounts")
	public ResponseEntity<Account>update(@RequestBody Account account) {
		 accountService.update(account);
		 return new ResponseEntity<Account>(HttpStatus.OK);
	}
	
	@DeleteMapping("/Accounts/{id}")
	public String deleteById(@PathVariable Long id)
	{
		accountService.deleteById(id);
		return "Deletion successful";
	}
	
	@GetMapping("/Accounts/{from}/{to}/{amount}")
	public String transferFund(@PathVariable Long from,@PathVariable Long to,@PathVariable int amount)
	{
		return accountService.transferFund(from,  to, amount);
	}
	
	
	@DeleteMapping("/Accounts")
	public String deleteAll()
	{
		accountService.deleteAll();
		return "All the accounts are deleted";
	}
}
