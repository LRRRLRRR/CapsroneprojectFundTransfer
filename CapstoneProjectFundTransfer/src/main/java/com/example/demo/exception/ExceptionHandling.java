package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
	public ResponseEntity<CustomerAccountErrorResponse> handle(AccountNotFoundException exc){
		
		CustomerAccountErrorResponse error=new CustomerAccountErrorResponse(HttpStatus.NOT_FOUND.value(),exc.getMessage(),System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerAccountErrorResponse> globalHandle(Exception exc)
	{
		CustomerAccountErrorResponse error= new CustomerAccountErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage(),System.currentTimeMillis());
		  return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	}
	
	

