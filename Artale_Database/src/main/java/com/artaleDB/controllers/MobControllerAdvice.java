package com.artaleDB.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoMobsFoundException;
import com.artaleDB.entities.TooManyMobsFoundException;

@RestControllerAdvice
public class MobControllerAdvice {
	
	@ExceptionHandler(NoMobsFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMobsFoundHanlder(NoMobsFoundException ex) {
		return ex.getMessage();
	}
	
	
	@ExceptionHandler(TooManyMobsFoundException.class)
	@ResponseStatus(HttpStatus.MULTIPLE_CHOICES)
	String tooManyMobsHandler(TooManyMobsFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoMatchingLocationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMatchingLocationHandler(NoMatchingLocationException ex) {
		return ex.getMessage();
	}
}
