package com.rest.firstExample.restproject.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.firstExample.restproject.service.userException;


@ControllerAdvice
@RestController
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) 
			throws Exception {
		ExceptionResponse response =new ExceptionResponse(new Date(), ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
		
	@ExceptionHandler(userException.class)
	public final ResponseEntity<Object> handleUserDefinedExceptions(Exception ex, WebRequest request) 
			throws Exception {
		ExceptionResponse response =new ExceptionResponse(new Date(), ex.getMessage(), 
				request.getDescription(false));
		return new ResponseEntity(response,HttpStatus.NOT_FOUND);
		
	}

}
