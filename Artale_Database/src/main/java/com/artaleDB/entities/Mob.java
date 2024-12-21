package com.artaleDB.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artale_mobs")
public class Mob {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mob_ID")
	private long id;
	
	@Column(name = "mob_Name")
	private String mobName;
	
	@Column(name = "mob_Level")
	private int mobLevel;
	
	@Column(name = "mob_HP")
	private int mobHP;
	
	@Column(name = "mob_MP")
	private int mobMP;
	
	@Column(name = "mob_EXP")
	private int mobEXP;
	
	@Column(name = "mob_Min_Meso")
	private long mobMinMeso;
	
	@Column(name = "mob_Max_Meso")
	private long mobMaxMeso;
	
	@Column(name = "mob_Needed_Accuracy")
	private int mobNeededAccuracy;
	
	@Column(name = "mob_Location")
	private String mobLocation;
	
	@Column(name = "mob_Location_Two")
	private String mobLocationTwo;

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
