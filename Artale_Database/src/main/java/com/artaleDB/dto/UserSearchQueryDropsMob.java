package com.artaleDB.dto;

public class UserSearchQueryDropsMob {
	
	String mobName;
	String equipmentName;
	
	public UserSearchQueryDropsMob(String mobName, String equipmentName) {
		super();
		this.mobName = mobName;
		this.equipmentName = equipmentName;
	}

	public String getMobName() {
		return mobName;
	}

	public void setMobName(String mobName) {
		this.mobName = mobName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	
	
}
