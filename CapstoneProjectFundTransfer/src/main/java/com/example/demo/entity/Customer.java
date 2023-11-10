package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="customer")

public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="cust_id")
	private Long customerId;
	
	@Column(name="cust_name")
	private String name;
	
	@Column(name="cust_address")
	private String address;
	
	@JsonIgnore
	@OneToOne(mappedBy="customer",cascade=CascadeType.ALL)
	private Account account;
	public Customer() {
		
	}
	
	public Customer(String name, String address) {
		super();
		this.name=name;
		this.address=address;
		//this.customerId=customerId;
	}
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	  
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	 public String toString() {
		return "Customer[customerId=" +customerId+ ",name=" +name+ ",address=" +address+",account="+account +"]";
		
	}

}
