package com.artaleDB.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "artale_mob_droplist")
public class MobDrops {
	
	private long mob_drop_id;
	
	private long mob_id;
	
	private long equipment_id;
	
	private String mob_name;
	
	private String equipment_name;

	public long getMob_drop_id() {
		return mob_drop_id;
	}

	public void setMob_drop_id(long mob_drop_id) {
		this.mob_drop_id = mob_drop_id;
	}

	public long getMob_id() {
		return mob_id;
	}

	public void setMob_id(long mob_id) {
		this.mob_id = mob_id;
	}

	public long getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(long equipment_id) {
		this.equipment_id = equipment_id;
	}
	
	public String getMob_name() {
		return mob_name;
	}

	public void setMob_name(String mob_name) {
		this.mob_name = mob_name;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}
	
	
}
