package com.artaleDB.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.artaleDB.entities.NoneFoundException;

/*
 * RestControllerAdvice class that handles what the application should do with certain exceptions
 */
@RestControllerAdvice
public class EquipmentControllerAdvice {
	
	/*
	 * Method that handles what the application should do when no equipment matching the parameter is found
	 * 
	 * @param ex NoneFoundException object
	 * @return a string message that is passed to the NoneFoundException constructor from the EquipmentService class
	 */
	@ExceptionHandler(NoneFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noEquipmentFoundHandler(NoneFoundException ex) {
		return ex.getMessage();
	}
	
}
