package com.artaleDB.entities;

public class TooManyFoundException extends RuntimeException{
	
	public TooManyFoundException(String msg) {
		super(msg);
	}
}
