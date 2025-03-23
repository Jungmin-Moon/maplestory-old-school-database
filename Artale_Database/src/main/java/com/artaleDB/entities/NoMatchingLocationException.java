package com.artaleDB.entities;

public class NoMatchingLocationException extends RuntimeException{
	
	public NoMatchingLocationException(String msg) {
		super(msg);
	}

}
