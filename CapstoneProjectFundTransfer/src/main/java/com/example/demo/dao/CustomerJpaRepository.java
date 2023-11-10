package com.example.demo.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Customer;


public interface CustomerJpaRepository  extends JpaRepository<Customer, Long>{
	
	@Query("Select c from Customer c where c.name= :name ")
      Customer findByName(String name);

}
