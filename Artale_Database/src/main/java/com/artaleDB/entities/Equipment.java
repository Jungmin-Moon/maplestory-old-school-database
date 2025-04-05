package com.artaleDB.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artale_equipment")
public class Equipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//representing armor, weapon or accessory as a string
	String equipmentType;
	
	//each will hold a string dictating what type of weapon, armor or accessory it is, these values can be null
	String weaponType;
	String armorType;
	String accessoryType;
	
	//minimum level can be 0 to 200
	int minimumLevel;
	
	//can be 0 to some value N
	int weaponAtt;
	int magicAtt;
	int attSpeed;
	
	//can be 0 to some value N
	int weaponDef;
	int magicDef;
	
	//booleans for job; if common is true, then all are true, if common is false then one or more of these have to be true for the equipment
	boolean warrior;
	boolean magician;
	boolean thief;
	boolean pirate;
	boolean archer;
	boolean common;
	
	//if equipment does not require a stat it will be given a value of -1
	int requiredStr;
	int requiredDex;
	int requiredInt;
	int requiredLuk;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public int getWeaponAtt() {
		return weaponAtt;
	}
	public void setWeaponAtt(int weaponAtt) {
		this.weaponAtt = weaponAtt;
	}
	public int getMagicAtt() {
		return magicAtt;
	}
	public void setMagicAtt(int magicAtt) {
		this.magicAtt = magicAtt;
	}
	public int getAttSpeed() {
		return attSpeed;
	}
	public void setAttSpeed(int attSpeed) {
		this.attSpeed = attSpeed;
	}
	public int getWeaponDef() {
		return weaponDef;
	}
	public void setWeaponDef(int weaponDef) {
		this.weaponDef = weaponDef;
	}
	public int getMagicDef() {
		return magicDef;
	}
	public void setMagicDef(int magicDef) {
		this.magicDef = magicDef;
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
	public boolean isPirate() {
		return pirate;
	}
	public void setPirate(boolean pirate) {
		this.pirate = pirate;
	}
	public boolean isArcher() {
		return archer;
	}
	public void setArcher(boolean archer) {
		this.archer = archer;
	}
	public boolean isCommon() {
		return common;
	}
	public void setCommon(boolean common) {
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
	public String getEffects() {
		return effects;
	}
	public void setEffects(String effects) {
		this.effects = effects;
	}
	public int getUpgrades() {
		return upgrades;
	}
	public void setUpgrades(int upgrades) {
		this.upgrades = upgrades;
	}
	public int getNpcVendorPrice() {
		return npcVendorPrice;
	}
	public void setNpcVendorPrice(int npcVendorPrice) {
		this.npcVendorPrice = npcVendorPrice;
	}
	String effects;
	int upgrades;
	int npcVendorPrice;
}
