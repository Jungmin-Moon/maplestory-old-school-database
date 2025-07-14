package com.artaleDB.dto;

public class UserSearchQueryMob {
	String mobName;
	int mobLevel;
	int mobEXP;
	String mobLocationOne;
	String mobLocationTwo;
	
	public UserSearchQueryMob(String mobName, int mobLevel, int mobEXP, String mobLocationOne, String mobLocationTwo) {
		super();
		this.mobName = mobName;
		this.mobLevel = mobLevel;
		this.mobEXP = mobEXP;
		this.mobLocationOne = mobLocationOne;
		this.mobLocationTwo = mobLocationTwo;
	}
	
	
	
	public String getMobName() {
		return mobName;
	}
	public void setMobName(String mobName) {
		this.mobName = mobName;
	}
	public int getMobLevel() {
		return mobLevel;
	}
	public void setMobLevel(int mobLevel) {
		this.mobLevel = mobLevel;
	}
	public int getMobEXP() {
		return mobEXP;
	}
	public void setMobEXP(int mobEXP) {
		this.mobEXP = mobEXP;
	}
	public String getMobLocationOne() {
		return mobLocationOne;
	}
	public void setMobLocationOne(String mobLocationOne) {
		this.mobLocationOne = mobLocationOne;
	}
	public String getMobLocationTwo() {
		return mobLocationTwo;
	}
	public void setMobLocationTwo(String mobLocationTwo) {
		this.mobLocationTwo = mobLocationTwo;
	}
	
	
}
