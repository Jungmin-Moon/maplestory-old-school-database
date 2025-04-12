package com.artaleDB.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.artaleDB.entities.NoneFoundException;

@RestControllerAdvice
public class EquipmentControllerAdvice {
	
	@ExceptionHandler(NoneFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String noEquipmentFoundHandler(NoneFoundException ex) {
		return ex.getMessage();
	}
	
}
