package com.verizon.customer.slackdemo.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  {
	@ExceptionHandler(value=Exception.class)
	public void HandleException(Throwable t){
		System.err.println();
	}
	
}
