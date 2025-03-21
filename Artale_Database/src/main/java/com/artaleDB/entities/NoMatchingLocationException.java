package com.artaleDB.entities;

public class NoMatchingLocationException extends RuntimeException{
	
	public NoMatchingLocationException(String location) {
		super("No mobs found in location: " + location + ". Please check the location you entered.");
	}

}
