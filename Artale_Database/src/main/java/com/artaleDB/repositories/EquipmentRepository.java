package com.artaleDB.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artaleDB.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
	
	//fetches rows in the table where the equipment type is the same as the passed in value
	@Query("SELECT e FROM Equipment e WHERE e.equipmentType = :equipmentType")
	Iterable<Equipment> findByEquipmentType(String equipmentType);
	
	@Query("SELECT e FROM Equipment e WHERE e.weaponType = :weaponType")
	Iterable<Equipment> findByWeaponType(String weaponType);
	
	@Query("SELECT e FROM Equipment e WHERE e.armorType = :armorType")
	Iterable<Equipment> findByArmorType(String armorType);
	
	@Query("SELECT e FROM Equipment e WHERE e.accessoryType = :accessoryType")
	Iterable<Equipment> findByAccessoryType(String accessoryType);
	
	Optional<Equipment> findAllByEquipmentName(String equipmentName);
	
	Iterable<Equipment> findAllByMinimumLevelGreaterThanEqual(int minLevel);
	
	Iterable<Equipment> findAllByWarrior(int warrior);
	
	Iterable<Equipment> findAllByMagician(int magician);
	
	Iterable<Equipment> findAllByThief(int thief);
	
	Iterable<Equipment> findAllByPirate(int pirate);
	
	Iterable<Equipment> findAllByArcher(int archer);
	
	Iterable<Equipment> findAllByCommon(int common);
	
	
	
	
	//Non exposed end points
	Iterable<Equipment> findAllByWeaponAttGreaterThanEqual(int weaponAtt);
	
	Iterable<Equipment> findAllByMagicAttGreaterThanEqual(int magicAtt);
	
	Iterable<Equipment> findAllByAttSpeedGreaterThanEqual(int attSpeed);
	
	Iterable<Equipment> findAllByWeaponDefGreaterThanEqual(int weaponDef);
	
	Iterable<Equipment> findAllByMagicDefGreaterThanEqual(int magicDef);
	
	Iterable<Equipment> findAllByRequiredStr(int str);
	
	Iterable<Equipment> findAllByRequiredDex(int dex);
	
	Iterable<Equipment> findAllByRequiredInt(int magic);
	
	Iterable<Equipment> findAllByRequiredLuk(int luk);
	
	Iterable<Equipment> findAllByUpgrades(int upgrades);
	
	Iterable<Equipment> findAllByNpcVendorPrice(int npcVendorPrice);
}
