package com.rest.firstExample.restproject.service;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class userException extends RuntimeException {

	public userException(String message){
		super(message);
	}
}
