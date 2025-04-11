package com.artaleDB.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;

@RestControllerAdvice
public class BossControllerAdvice {
	
	@ExceptionHandler(NoneFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noBossesFoundHanlder(NoneFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoMatchingLocationException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noMatchingLocationhandler(NoMatchingLocationException ex) {
		return ex.getMessage();
	}
}
