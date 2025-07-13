package com.artaleDB.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "artale_mob_droplist")
public class MobDrops {
	
	@Id
	private long mobDropId;
	
	private long mobId;
	
	private long equipmentId;
	
	private String mobName;
	
	private String equipmentName;

	public long getMob_drop_id() {
		return mobDropId;
	}

	public void setMob_drop_id(long mob_drop_id) {
		this.mobDropId = mob_drop_id;
	}

	public long getMob_id() {
		return mobId;
	}

	public void setMob_id(long mob_id) {
		this.mobId = mob_id;
	}

	public long getEquipment_id() {
		return equipmentId;
	}

	public void setEquipment_id(long equipment_id) {
		this.equipmentId = equipment_id;
	}
	
	public String getMob_name() {
		return mobName;
	}

	public void setMob_name(String mob_name) {
		this.mobName = mob_name;
	}

	public String getEquipment_name() {
		return equipmentName;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipmentName = equipment_name;
	}
	
	
}
