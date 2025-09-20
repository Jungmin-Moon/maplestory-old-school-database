package com.artaleDB.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
/*
 * Equipment Entity class with states that are most relevant to users
 */
@Entity
@Table(name = "artale_equipment")
public class Equipment {
	
	/* Represents the ID of the equipment in the database*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipment_id")
	private long id;
	
	/* Represents the name of the equipment */
	private String equipmentName;
	
	/* Represents if the equipment is a weapon, armor or accessory */
	private String equipmentType;
	
	/* Each of the three represents a type for each category of equipment
	 * If equipment is a weapon, armorType and accessoryType will be represented with a dash ( - )
	 * If equipment is an armor, weapon and accessory will be represented with a dash ( - )
	 * If equipment is an accessory, weapon and armor will be represented with a dash ( - )
	 * Weapons can only be weapon types that exist in Maplestory in this era of the game: 
	 * [One Handed Sword, Two Handed Sword, One Handed Axe, Two Handed Axe, One Handed Blunt Weapon, Two Handed Blunt Weapon, Bow, 
	 * Crossbow, Claw, Dagger, Spear, Polearm, Wand, Staff, Knuckle, Gun]
	 * Armors can only be [Hat, Top, Overall, Bottom, Shoes, Gloves, Cape, Shield]
	 * Accessories can only be [Earring, Eye Accessory, Face Accessory, Pendant, Belt, Medal, Ring, Shoulderpad]
	 */
	private String weaponType;
	private String armorType;
	private String accessoryType;
	
	/* Represents the minimum level needed to equip something. The value of this can be from 0 to 200*/
	private int minimumLevel;
	
	/*
	 * Represents a stat that weapons can have.
	 * Generally a weapon with weapon attack, will not have magic att and vice versa
	 * All weapons have attack speed that can be of value between 
	 */
	private String weaponAtt;
	private String magicAtt;
	private String attSpeed;
	
	/*
	 * Represents the weapon defense and magic defense of armor and some accessories
	 * Can be some value 0 to N
	 */
	private String weaponDef;
	private String magicDef;
	
	/*
	 * Represents what jobs can wear the equipment
	 * Represented with 0 for false and 1 for true.
	 * Many equipment can be worn by multiple roles.
	 */
	private int warrior;
	private int magician;
	private int thief;
	private int pirate;
	private int archer;
	private int common;
	
	/*
	 * Represents the required amount of a stat needed to wear the equpiment
	 * Can be 0 to some value N
	 */
	private int requiredStr;
	private int requiredDex;
	private int requiredInt;
	private int requiredLuk;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getWeaponAtt() {
		return weaponAtt;
	}
	public void setWeaponAtt(String weaponAtt) {
		this.weaponAtt = weaponAtt;
	}
	public String getMagicAtt() {
		return magicAtt;
	}
	public void setMagicAtt(String magicAtt) {
		this.magicAtt = magicAtt;
	}
	public String getAttSpeed() {
		return attSpeed;
	}
	public void setAttSpeed(String attSpeed) {
		this.attSpeed = attSpeed;
	}
	public String getWeaponDef() {
		return weaponDef;
	}
	public void setWeaponDef(String weaponDef) {
		this.weaponDef = weaponDef;
	}
	public String getMagicDef() {
		return magicDef;
	}
	public void setMagicDef(String magicDef) {
		this.magicDef = magicDef;
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
	public int isPirate() {
		return pirate;
	}
	public void setPirate(int pirate) {
		this.pirate = pirate;
	}
	public int isArcher() {
		return archer;
	}
	public void setArcher(int archer) {
		this.archer = archer;
	}
	public int isCommon() {
		return common;
	}
	public void setCommon(int common) {
		this.common = common;
	}
	public int getRequiredStr() {
		return requiredStr;
	}
	public void setRequiredStr(int requiredStr) {
		this.requiredStr = requiredStr;
	}
	public int getRequiredDex() {
		return requiredDex;
	}
	public void setRequiredDex(int requiredDex) {
		this.requiredDex = requiredDex;
	}
	public int getRequiredInt() {
		return requiredInt;
	}
	public void setRequiredInt(int requiredInt) {
		this.requiredInt = requiredInt;
	}
	public int getRequiredLuk() {
		return requiredLuk;
	}
	public void setRequiredLuk(int requiredLuk) {
		this.requiredLuk = requiredLuk;
	}


}
