package com.artaleDB.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artale_boss")
public class Boss {
	
	@Id
	@Column(name = "boss_ID")
	private long id;
	
	private String bossName;
	
	private int bossLevel;
	
	private int bossHP;
	
	private String bossMinRespawn;
	
	private String bossMaxRespawn;
	
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

	public String getBossMinRespawn() {
		return bossMinRespawn;
	}

	public void setBossMinRespawn(String bossMinRespawn) {
		this.bossMinRespawn = bossMinRespawn;
	}

	public String getBossMaxRespawn() {
		return bossMaxRespawn;
	}

	public void setBossMaxRespawn(String bossMaxRespawn) {
		this.bossMaxRespawn = bossMaxRespawn;
	}

	public String getBossLocation() {
		return bossLocation;
	}

	public void setBossLocation(String bossLocation) {
		this.bossLocation = bossLocation;
	}
	
	
	
}
