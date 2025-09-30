package com.artaleDB.dto;

public class UserSearchQueryEquipment {
	
	String equipmentName;
	String equipmentType;
	int minimumLevel;
	int warrior;
	int magician;
	int thief;
	int archer;
	int pirate;
	int beginner;
	int common;
	
	
	public UserSearchQueryEquipment(String equipmentName, String equipmentType,
			int minimumLevel, int warrior, int magician, int thief, int archer,
			int pirate, int beginner, int common) {
		super();
		this.equipmentName = equipmentName;
		this.equipmentType = equipmentType;
		this.minimumLevel = minimumLevel;
		this.warrior = warrior;
		this.magician = magician;
		this.thief = thief;
		this.archer = archer;
		this.pirate = pirate;
		this.beginner = beginner;
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




	public int getMinimumLevel() {
		return minimumLevel;
	}


	public void setMinimumLevel(int minimumLevel) {
		this.minimumLevel = minimumLevel;
	}


	public int isWarrior() {
		return warrior;
	}


	public void setWarrior(int warrior) {
		this.warrior = warrior;
	}


	public int isMagician() {
		return magician;
	}


	public void setMagician(int magician) {
		this.magician = magician;
	}


	public int isThief() {
		return thief;
	}


	public void setThief(int thief) {
		this.thief = thief;
	}


	public int isArcher() {
		return archer;
	}


	public void setArcher(int archer) {
		this.archer = archer;
	}


	public int isPirate() {
		return pirate;
	}


	public void setPirate(int pirate) {
		this.pirate = pirate;
	}


	public int isCommon() {
		return common;
	}


	public void setCommon(int common) {
		this.common = common;
	}
	
	public String toString() {
		return "Equipment Name: " + equipmentName + "\n" + 
				"Equipment Type: " + equipmentType + "\n" + 
				"Minimum Level: " + minimumLevel + "\n" + 
				"Warrior: " + warrior + "\n" +
				"Magician: " + magician + "\n" +
				"Thief: " + thief + "\n" +
				"Archer: " + archer + "\n" + 
				"Pirate: " + pirate + "\n" + 
				"Common: " + common + "\n";
	}
	
}
