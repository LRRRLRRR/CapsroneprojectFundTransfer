package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="acc_no")
	private Long accountNumber;
	
	@Column(name="acc_Type")
	private  String accountType;
	
	@Column(name="balance")
	private int balance;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cust_id")
	private Customer customer;
	public Account(){
		
	}
	
	public Account(String accountType, int balance) {
		super();
		this.accountType=accountType;
		this.balance=balance;
		//this.accountNumber=accountNumber;
		
		
	}
	
	
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setCustomer(Customer customer) {
		this.customer=customer;
	}
	
	
	
	public Customer getCustomer() {
		return customer;
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" +accountNumber +", accountType="+accountType +", balance="+balance+",customer="+customer+"]";
		
	}
	
}
