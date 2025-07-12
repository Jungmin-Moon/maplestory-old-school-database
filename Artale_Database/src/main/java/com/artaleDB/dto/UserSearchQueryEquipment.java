package com.artaleDB.dto;

public record UserSearchQueryEquipment(
		
		String equipmentName,
		String equipmentType,
		String weaponType,
		String armorType,
		String accessoryType,
		int minimumLevel,
		boolean warrior,
		boolean magician,
		boolean thief,
		boolean pirate,
		boolean archer,
		boolean common
		
		) 
{}
