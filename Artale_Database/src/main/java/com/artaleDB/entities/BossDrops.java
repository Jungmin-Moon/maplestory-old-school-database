package com.artaleDB.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "artale_boss_droplist")
public class BossDrops {

	
	private long boss_id;
	
	private long equipment_id;
	
	private String boss_name;
	
	private String equipment_name;

	public long getBoss_id() {
		return boss_id;
	}

	public void setBoss_id(long boss_id) {
		this.boss_id = boss_id;
	}

	public long getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(long equipment_id) {
		this.equipment_id = equipment_id;
	}

	public String getBoss_name() {
		return boss_name;
	}

	public void setBoss_name(String boss_name) {
		this.boss_name = boss_name;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}
	
	
}
