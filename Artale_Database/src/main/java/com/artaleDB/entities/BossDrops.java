package com.artaleDB.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artale_boss_droplist")
public class BossDrops {

	@Id
	private long bossDropId;
	
	private long bossId;
	
	private long equipmentId;
	
	private String bossName;
	
	private String equipmentName;

	public long getBoss_drop_id() {
		return bossDropId;
	}

	public void setBoss_drop_id(long boss_drop_id) {
		this.bossDropId = boss_drop_id;
	}

	public long getBoss_id() {
		return bossId;
	}

	public void setBoss_id(long boss_id) {
		this.bossId = boss_id;
	}

	public long getEquipment_id() {
		return equipmentId;
	}

	public void setEquipment_id(long equipment_id) {
		this.equipmentId = equipment_id;
	}

	public String getBoss_name() {
		return bossName;
	}

	public void setBoss_name(String boss_name) {
		this.bossName = boss_name;
	}

	public String getEquipment_name() {
		return equipmentName;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipmentName = equipment_name;
	}
	
	
}
