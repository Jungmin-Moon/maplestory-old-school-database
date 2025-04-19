package com.artaleDB.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
 * Class representing a Boss object when gotten from a database with the pertinent information such as name, hp, 
 * level, respawn time and location
 */
@Entity
@Table(name = "artale_boss")
public class Boss {
	
	/*Represents the id of the Boss */
	@Id
	@Column(name = "boss_ID")
	private long id;
	
	/*Represents the name of the Boss */
	private String bossName;
	
	/*Represents the level of the Boss */
	private int bossLevel;
	
	/*Represents the max hp of the Boss */
	@Column(name = "boss_HP")
	private int bossHP;
	
	/*Represents the minimum time and maximum time it takes before the Boss Respawns. Timer is represented in minutes */
	private int bossMinRespawn;
	private int bossMaxRespawn;
	
	/*Represents the location where the Boss can be found */
	private String bossLocation;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public int getBossLevel() {
		return bossLevel;
	}

	public void setBossLevel(int bossLevel) {
		this.bossLevel = bossLevel;
	}

	public int getBossHP() {
		return bossHP;
	}

	public void setBossHP(int bossHP) {
		this.bossHP = bossHP;
	}

	public int getBossMinRespawn() {
		return bossMinRespawn;
	}

	public void setBossMinRespawn(int bossMinRespawn) {
		this.bossMinRespawn = bossMinRespawn;
	}

	public int getBossMaxRespawn() {
		return bossMaxRespawn;
	}

	public void setBossMaxRespawn(int bossMaxRespawn) {
		this.bossMaxRespawn = bossMaxRespawn;
	}

	public String getBossLocation() {
		return bossLocation;
	}

	public void setBossLocation(String bossLocation) {
		this.bossLocation = bossLocation;
	}
	
	
	
}
