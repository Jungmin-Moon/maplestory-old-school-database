package com.artaleDB.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.entities.TooManyFoundException;

/*
 * Advice class that tells the application how to handle certain Exceptions.
 * Instead of overloading the user with a stack trace, they will instead be greeted with messages describing 
 * the error in a simplified but detailed manner.
 */

@RestControllerAdvice
public class MobControllerAdvice {
	
	/*
	 * Method to handle the custom NoneFoundException Exception and what HTTP Status to return
	 * 
	 * @param ex a NoneFoundException object
	 * @return the message passed to the NoneFoundException constructor from the MobService method
	 */
	@ExceptionHandler(NoneFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMobsFoundHanlder(NoneFoundException ex) {
		return ex.getMessage();
	}
	
	/*
	 * Method to handle the TooManyFoundException Exception and what HTTP Status to return
	 * 
	 * @param ex a TooManyFoundException object
	 * @return the message passed to the TooManyFoundException constructor from the MobService method
	 */
	@ExceptionHandler(TooManyFoundException.class)
	@ResponseStatus(HttpStatus.MULTIPLE_CHOICES)
	String tooManyMobsHandler(TooManyFoundException ex) {
		return ex.getMessage();
	}
	
	/*
	 * Method to handle the NoMatchingLocationException Exception and what HTTP Status to return
	 * 
	 * @param ex a NoMatchingLocationException object
	 * @return the message passed to the NoMatchingLocationException constructor from the MobService method
	 */
	@ExceptionHandler(NoMatchingLocationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMatchingLocationHandler(NoMatchingLocationException ex) {
		return ex.getMessage();
	}
}
