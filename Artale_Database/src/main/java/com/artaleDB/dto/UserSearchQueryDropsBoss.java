package com.artaleDB.dto;

public class UserSearchQueryDropsBoss {
	
	String bossName;
	String equipmentName;
	
	public UserSearchQueryDropsBoss(String bossName, String equipmentName) {
		super();
		this.bossName = bossName;
		this.equipmentName = equipmentName;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	
}
