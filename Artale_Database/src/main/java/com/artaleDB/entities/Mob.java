package com.artaleDB.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*
 * Represents the most important aspects about a Mob that a player will want to know. 
 * Used to create Mob objects to save to the database. 
 */

@Entity
@Table(name = "artale_mobs")
public class Mob {
	
	/*Identifies the mob in the database */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mob_ID")
	private long id;
	
	/*Name of the mob */
	@Column(name = "mob_Name")
	private String mobName;
	
	/*Represents the level of the mob */
	@Column(name = "mob_Level")
	private int mobLevel;
	
	/*Represents the mob's  max HP */
	@Column(name = "mob_HP")
	private int mobHP;
	
	/*Represents the mob's max MP */
	@Column(name = "mob_MP")
	private int mobMP;
	
	/*Represents the exp a mob gives upon defeat */
	@Column(name = "mob_EXP")
	private int mobEXP;
	
	/*Represents the minimum amount of meso the mob can drop upon defeat */
	@Column(name = "mob_Min_Meso")
	private long mobMinMeso;
	
	/*Represents the maximum amount of meso the mob can drop upon defeat */
	@Column(name = "mob_Max_Meso")
	private long mobMaxMeso;
	
	/*Represents the accuracy needed to hit the mob */
	@Column(name = "mob_Needed_Accuracy")
	private int mobNeededAccuracy;
	
	/*Represents one location where the mob can be found */
	@Column(name = "mob_Location")
	private String mobLocation;
	
	/*Represents a second location where the mob can be found */
	@Column(name = "mob_Location_Two")
	private String mobLocationTwo;

	/*List of getters and setters for the Mob Object */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getMobHP() {
		return mobHP;
	}

	public void setMobHP(int mobHP) {
		this.mobHP = mobHP;
	}

	public int getMobMP() {
		return mobMP;
	}

	public void setMobMP(int mobMP) {
		this.mobMP = mobMP;
	}

	public int getMobEXP() {
		return mobEXP;
	}

	public void setMobEXP(int mobEXP) {
		this.mobEXP = mobEXP;
	}

	public long getMobMinMeso() {
		return mobMinMeso;
	}

	public void setMobMinMeso(long mobMinMeso) {
		this.mobMinMeso = mobMinMeso;
	}
	
	public long getMobMaxMeso() {
		return mobMaxMeso;
	}

	public void setMobMaxMeso(long mobMaxMeso) {
		this.mobMaxMeso = mobMaxMeso;
	}

	public int getMobNeededAccuracy() {
		return mobNeededAccuracy;
	}

	public void setMobNeededAccuracy(int mobNeededAccuracy) {
		this.mobNeededAccuracy = mobNeededAccuracy;
	}

	public String getMobLocation() {
		return mobLocation;
	}

	public void setMobLocation(String mobLocation) {
		this.mobLocation = mobLocation;
	}

	public String getMobLocationTwo() {
		return mobLocationTwo;
	}

	public void setMobLocationTwo(String mobLocationTwo) {
		this.mobLocationTwo = mobLocationTwo;
	}
	
	
	
}
