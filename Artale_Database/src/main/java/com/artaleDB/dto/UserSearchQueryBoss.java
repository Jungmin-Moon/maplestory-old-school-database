package com.artaleDB.dto;

public class UserSearchQueryBoss {
	
	String bossName;
	int bossLevel;
	int bossMinRespawn;
	int bossMaxRespawn;
	String bossLocationOne;
	String bossLocationTwo;
	
	public UserSearchQueryBoss(String bossName, int bossLevel, int bossMinRespawn, int bossMaxRespawn,
			String bossLocationOne, String bossLocationTwo) {
		super();
		this.bossName = bossName;
		this.bossLevel = bossLevel;
		this.bossMinRespawn = bossMinRespawn;
		this.bossMaxRespawn = bossMaxRespawn;
		this.bossLocationOne = bossLocationOne;
		this.bossLocationTwo = bossLocationTwo;
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

	public String getBossLocationOne() {
		return bossLocationOne;
	}

	public void setBossLocationOne(String bossLocationOne) {
		this.bossLocationOne = bossLocationOne;
	}

	public String getBossLocationTwo() {
		return bossLocationTwo;
	}

	public void setBossLocationTwo(String bossLocationTwo) {
		this.bossLocationTwo = bossLocationTwo;
	}
	
	
	
}
