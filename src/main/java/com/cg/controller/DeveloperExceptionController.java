package com.cg.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.exception.DeveloperNotFoundException;




	@ControllerAdvice
	public class DeveloperExceptionController {

		@ExceptionHandler(value=DeveloperNotFoundException.class)
		public ResponseEntity<Object> developerCodeExceptionHandler(Exception ex){
		
			return new ResponseEntity("Developer Not Found",HttpStatus.NOT_FOUND);
		}
		
		
	}

