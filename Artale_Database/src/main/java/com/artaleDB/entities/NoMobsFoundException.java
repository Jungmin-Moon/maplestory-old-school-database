package com.artaleDB.entities;

public class NoMobsFoundException extends RuntimeException{
	
	public NoMobsFoundException(String name) {
		super("No mobs were found with the name: " + name + ". Please try again with a more specific name.");
	}
	
	public NoMobsFoundException(int level) {
		super("No mobs were found with the level: " + level + ". Please enter a different number.");
		
	}
	
	public NoMobsFoundException() {
		super("No mobs found in the database.");
	}
}
