package com.cogent.productmanagementrestthyme.controller;

import com.cogent.productmanagementrestthyme.exception.*;
	
	import java.util.Date;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ControllerAdvice;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.context.request.WebRequest;

	public class GlobalExceptionHandler {
		
		@ExceptionHandler(ResourceNotFoundException.class)
	    //Means current method is going to handle 
	    //ResourceNotFoundException exception
	    public ResponseEntity<?> resourceNotFoundException
	    (ResourceNotFoundException ex, WebRequest request) {
	    	System.out.println("Exception handling for resource");
	         ErrorDetails errorDetails = new ErrorDetails (new Date(), ex.getMessage(), request.getDescription(false));
	         return new ResponseEntity<>(errorDetails,
	        HttpStatus.NOT_FOUND);//404
	         
	        //http://localhost:8080/students/104
	        // resourcenotfoundexception
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globleExcpetionHandler
	    (Exception ex, WebRequest request) {
	        ErrorDetails errorDetails =
	        new ErrorDetails(new Date(), 
	        ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errorDetails, 
	        		HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

		
		
		
		
		
		
		
		


	