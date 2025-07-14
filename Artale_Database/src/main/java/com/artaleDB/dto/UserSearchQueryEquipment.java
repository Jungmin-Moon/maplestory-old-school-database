package com.artaleDB.dto;

public class UserSearchQueryEquipment {
	
	String equipmentName;
	String equipmentType;
	String weaponType;
	String armorType;
	String accessoryType;
	int minimumLevel;
	boolean warrior;
	boolean magician;
	boolean thief;
	boolean archer;
	boolean pirate;
	boolean common;
	
	
	public UserSearchQueryEquipment(String equipmentName, String equipmentType, String weaponType, String armorType,
			String accessoryType, int minimumLevel, boolean warrior, boolean magician, boolean thief, boolean archer,
			boolean pirate, boolean common) {
		super();
		this.equipmentName = equipmentName;
		this.equipmentType = equipmentType;
		this.weaponType = weaponType;
		this.armorType = armorType;
		this.accessoryType = accessoryType;
		this.minimumLevel = minimumLevel;
		this.warrior = warrior;
		this.magician = magician;
		this.thief = thief;
		this.archer = archer;
		this.pirate = pirate;
		this.common = common;
	}


	public String getEquipmentName() {
		return equipmentName;
	}


	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}


	public String getEquipmentType() {
		return equipmentType;
	}


	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}


	public String getWeaponType() {
		return weaponType;
	}


	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}


	public String getArmorType() {
		return armorType;
	}


	public void setArmorType(String armorType) {
		this.armorType = armorType;
	}


	public String getAccessoryType() {
		return accessoryType;
	}


	public void setAccessoryType(String accessoryType) {
		this.accessoryType = accessoryType;
	}


	public int getMinimumLevel() {
		return minimumLevel;
	}


	public void setMinimumLevel(int minimumLevel) {
		this.minimumLevel = minimumLevel;
	}


	public boolean isWarrior() {
		return warrior;
	}


	public void setWarrior(boolean warrior) {
		this.warrior = warrior;
	}


	public boolean isMagician() {
		return magician;
	}


	public void setMagician(boolean magician) {
		this.magician = magician;
	}


	public boolean isThief() {
		return thief;
	}


	public void setThief(boolean thief) {
		this.thief = thief;
	}


	public boolean isArcher() {
		return archer;
	}


	public void setArcher(boolean archer) {
		this.archer = archer;
	}


	public boolean isPirate() {
		return pirate;
	}


	public void setPirate(boolean pirate) {
		this.pirate = pirate;
	}


	public boolean isCommon() {
		return common;
	}


	public void setCommon(boolean common) {
		this.common = common;
	}
	
	
	
}
