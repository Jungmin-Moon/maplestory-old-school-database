package com.artaleDB.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artaleDB.entities.Equipment;
/*
 * Repository holding queries that will be used by the endpoints exposed by EquipmentController
 */
public interface EquipmentRepository extends JpaRepository<Equipment, Long>{
	
	/* Query that finds equipment in the database whose type is equal to the passed in String*/
	/* To be removed
	@Query("SELECT e FROM Equipment e WHERE e.equipmentType = :equipmentType")
	Iterable<Equipment> findByEquipmentType(String equipmentType); */
	
	/* Query that finds equipment where the weaponType is equal to the passed in String*/
	@Query("SELECT e FROM Equipment e WHERE e.equipmentType = :weaponType")
	Iterable<Equipment> findByWeaponType(String weaponType);
	
	/* Query that finds equipment where the armorType is equal to the passed in String*/
	@Query("SELECT e FROM Equipment e WHERE e.equipmentType = :armorType")
	Iterable<Equipment> findByArmorType(String armorType);
	
	/* Query that finds equipment where the accessoryType is equal to the passed in String*/
	@Query("SELECT e FROM Equipment e WHERE e.equipmentType = :accessoryType")
	Iterable<Equipment> findByAccessoryType(String accessoryType);
	
	/* Query to find equipment whose name is equal to the passed in String*/
	Optional<Equipment> findAllByEquipmentName(String equipmentName);
	
	/* Query to find a collection of equipment whose name contains the passed in substring*/
	@Query("SELECT e FROM Equipment e WHERE e.equipmentName LIKE %:subString%")
	Iterable<Equipment> findAllByNamePartialmatch(String subString);
	
	/* Query to find equipment whose minimum level to equip them is greater than or equal to the passed in int*/
	Iterable<Equipment> findAllByMinimumLevelGreaterThanEqual(int minLevel);
	
	/* Query to find a collection of equipment that can be equipped by warriors*/
	Iterable<Equipment> findAllByWarrior(int warrior);
	
	/* Query to find a collection of equipment that can be equipped by magicians*/
	Iterable<Equipment> findAllByMagician(int magician);
	
	/* Query to find a collection of equipment that can be equipped by thieves*/
	Iterable<Equipment> findAllByThief(int thief);
	
	/* Query to find a collection of equipment that can be equipped by pirates*/
	Iterable<Equipment> findAllByPirate(int pirate);
	
	/* Query to find a collection of equipment that can be equipped by archers*/
	Iterable<Equipment> findAllByArcher(int archer);
	
	/* Query to find a collection of equipment that can be equipped by all jobs*/
	Iterable<Equipment> findAllByCommon(int common);
	
	/* Query to find a collection of equipment that can be equipped by only beginners*/
	Iterable<Equipment> findAllByBeginner(int beginner);
	
	
	
	//Web queries
	List<Equipment> findAllByOrderByMinimumLevelAsc();
}
