package com.artaleDB.entities;

public class TooManyMobsFoundException extends RuntimeException{
	
	public TooManyMobsFoundException(String name) {
		super("There were too many mobs with name similar to: " + name + " found. Please be more specific.");
	}
}
