package com.artaleDB.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
/*
 * Class that handles what should occur when the custom exceptions NoneFoundException and NoMatchingLocationException occur when a user 
 * accesses a endpoint
 */
@RestControllerAdvice
public class BossControllerAdvice {
	
	/*
	 * Method that handles the NoneFoundException exception and what HTTP Status to return.
	 * 
	 * @param ex a NoneFoundException object
	 * @return the message passed by the method in BossService to the Exception constructor
	 */
	@ExceptionHandler(NoneFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noBossesFoundHanlder(NoneFoundException ex) {
		return ex.getMessage();
	}
	
	/*
	 * Method that handles the NoMatchingLocationException exception and what HTTP Status to return.
	 * 
	 * @param ex a NoMatchingLocationException object
	 * @return the message passed by the method in BossService to the Exception constructor
	 */
	@ExceptionHandler(NoMatchingLocationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMatchingLocationhandler(NoMatchingLocationException ex) {
		return ex.getMessage();
	}
}
