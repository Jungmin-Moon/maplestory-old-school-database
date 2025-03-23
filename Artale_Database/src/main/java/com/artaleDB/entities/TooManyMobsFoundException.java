package com.artaleDB.entities;

public class TooManyMobsFoundException extends RuntimeException{
	
	public TooManyMobsFoundException(String msg) {
		super(msg);
	}
}
