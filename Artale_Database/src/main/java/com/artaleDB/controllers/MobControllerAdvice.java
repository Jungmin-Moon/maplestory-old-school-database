package com.artaleDB.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.entities.TooManyFoundException;

@RestControllerAdvice
public class MobControllerAdvice {
	
	@ExceptionHandler(NoneFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMobsFoundHanlder(NoneFoundException ex) {
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(TooManyFoundException.class)
	@ResponseStatus(HttpStatus.MULTIPLE_CHOICES)
	String tooManyMobsHandler(TooManyFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoMatchingLocationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMatchingLocationHandler(NoMatchingLocationException ex) {
		return ex.getMessage();
	}
}
