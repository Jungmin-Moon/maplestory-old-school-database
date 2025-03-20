package com.artaleDB.entities;

public class NoMobsFoundException extends RuntimeException{
	
	public NoMobsFoundException(String name) {
		super("No mobs were found with the name: " + name + ". Please try again with a more specific name.");
	}
}
