package com.artaleDB.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Equipment;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.EquipmentRepository;
/*
 * Service class that handles getting all information from the database and passes it to the EquipmentController in JSON
 */
@Service
public class EquipmentService {
	
	EquipmentRepository equipmentRepository;
	CalculationService calculationService;
	
	public EquipmentService(EquipmentRepository equipmentRepository, CalculationService calculationService) {
		this.equipmentRepository = equipmentRepository;
		this.calculationService = calculationService;
	}
	
	/*
	 * Service method that returns all the equipment in the database
	 * 
	 * @return Iterable<Equipment> a collection of all equipment in the database.
	 */
	public Iterable<Equipment> getAllEquipment() {
		var equipmentAll = equipmentRepository.findAll();
		
		long count = calculationService.getCount(equipmentAll);
		
		if (count <= 0) {
			throw new NoneFoundException("The database is currently empty.");
		} else {
			return equipmentRepository.findAll();
		}
	}
	
	/*
	 * Service method to look for equipment with the exact same name as the one provided
	 * 
	 * @param name a String input to search for in the database
	 * @return Optional<Equipment> if an equipment with the same name as the parameter in the database
	 * @throws NoneFoundException if no equipment in the database has the exact same name as the parameter
	 */
	public Optional<Equipment> getEquipmentByName(String name) {
		
		var equipment = equipmentRepository.findAllByEquipmentName(name);
		
		if (equipment == null) {
			throw new NoneFoundException("There is no equipment in the database with that name.");
		} else {
			return equipment;
		}
	}
	
	/*
	 * Service method that returns all equipment whose name contains the substring
	 * 
	 * @param substring used to search equipment name to see if they contain the substring
	 * @return Iterable<Equipment> a collection of equipment who contain the parameter in their name
	 * @throws NoneFoundException if no equipment in the database contains the parameter in their name
	 */
	public Iterable<Equipment> getEquipmentByNamePartialMatch(String subString) {
		var equipmentList = equipmentRepository.findAllByNamePartialmatch(subString);
		
		long count = calculationService.getCount(equipmentList);
		
		if (count <= 0) {
			throw new NoneFoundException("There is no equipment containing this word.");
		} else {
			return equipmentList;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment whose type is equal to the passed in string [Armor, Weapon or Accessory]
	 * 
	 * @param equipmentType the string representing what equipment type the user is searching for
	 * @return Iterable<Equipment> a collection of equipment who type is equal to the passed in parameter
	 * @throws NoneFoundException if no equipment in the database has their type equal to the string parameter
	 */
	public Iterable<Equipment> getEquipmentByType(String equipmentType) {
		var equipmentListByType = equipmentRepository.findByEquipmentType(equipmentType);
		
		long count = calculationService.getCount(equipmentListByType);
		
		if (count <= 0) {
			throw new NoneFoundException("There is no equipment that are " + equipmentType + " in the database.");
		} else {
			return equipmentListByType;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment whose weapon type is equal to the passed in string
	 * 
	 * @param weaponType the string representing what kind of weapon the user is searching for
	 * @return Iterable<Equipment> a collection of equipment who have their weapon type equal to the parameter
	 * @throws NoneFoundException if no equipment in the database has a weapon type that is equal to the parameter
	 */
	public Iterable<Equipment> getAllByWeaponType(String weaponType) {
		var equipmentListByWeaponType = equipmentRepository.findByWeaponType(weaponType);
		
		long count = calculationService.getCount(equipmentListByWeaponType);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no weapons of type: " + weaponType + " in the dabatase.");
		} else {
			return equipmentListByWeaponType;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment whose armor type is equal to the passed in string
	 * 
	 * @param armorType the string representing what kind of armor the user is searching for
	 * @return Iterable<Equipment> a collection of equipment who have their armor type equal to the parameter
	 * @throws NoneFoundException if no equipment in the database has a armor type that is equal to the parameter
	 */
	public Iterable<Equipment> getAllByArmorType(String armorType) {
		var equipmentListByArmorType = equipmentRepository.findByArmorType(armorType);
		
		long count = calculationService.getCount(equipmentListByArmorType);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no armor of type: " + armorType + " in the database.");
		} else {
			return equipmentListByArmorType;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment whose accessory type is equal to the passed in string
	 * 
	 * @param accessoryType the string representing what kind of accessory the user is searching for
	 * @return Iterable<Equipment> a collection of equipment who have their accessory type equal to the parameter
	 * @throws NoneFoundException if no equipment in the database has an accessory type that is equal to the parameter
	 */
	public Iterable<Equipment> getAllByAccessoryType(String accessoryType) {
		var equipmentListByAccessoryType = equipmentRepository.findByAccessoryType(accessoryType);
		
		long count = calculationService.getCount(equipmentListByAccessoryType);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no accessories of type: " + accessoryType + " in the database.");
		} else {
			return equipmentListByAccessoryType;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment whose minimum level is greater than or equal to the paramater
	 * 
	 * @param level int representing the minimum level of equipment the user is searching for
	 * @return Iterable<Equipment> a collection of equipment whose minimum level is greater than or equal to the parameter
	 * @throws NoneFoundException if no equipment in the database has a minimum level that is greater than or equal to the parameter
	 */
	public Iterable<Equipment> getAllByMinLevelGreaterThanEqual(int level) {
		var equipmentListByMinLevel = equipmentRepository.findAllByMinimumLevelGreaterThanEqual(level);
		
		long count = calculationService.getCount(equipmentListByMinLevel);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no equipment with a minimum level " + level + " or higher.");
		} else {
			return equipmentListByMinLevel;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment that can be worn by warriors
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by warriors
	 * @throws NoneFoundException if no equipment in the database can be worn by warriors
	 */
	public Iterable<Equipment> getAllEquipableWarrior() {
		var equipmentListEquippableWarrior = equipmentRepository.findAllByWarrior(1);
		
		long count = calculationService.getCount(equipmentListEquippableWarrior);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equiment that warriors can equip found.");
		} else {
			return equipmentListEquippableWarrior;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment that can be worn by magicians
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by magicians
	 * @throws NoneFoundException if no equipment in the database can be worn by magicians
	 */
	public Iterable<Equipment> getAllEquipableMagician() {
		var equipmentListEquippableMagician = equipmentRepository.findAllByMagician(1);
		
		long count = calculationService.getCount(equipmentListEquippableMagician);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that magicians can equip found.");
		} else {
			return equipmentListEquippableMagician;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment that can be worn by archers
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by archers
	 * @throws NoneFoundException if no equipment in the database can be worn by archers
	 */
	public Iterable<Equipment> getAllEquipableArcher() {
		var equipmentListEquippableArcher = equipmentRepository.findAllByArcher(1);
		
		long count = calculationService.getCount(equipmentListEquippableArcher);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that archers can equip found.");
		} else {
			return equipmentListEquippableArcher;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment that can be worn by thieves
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by thieves
	 * @throws NoneFoundException if no equipment in the database can be worn by thieves
	 */
	public Iterable<Equipment> getAllEquipableThief() {
		var equipmentListEquippableThief = equipmentRepository.findAllByThief(1);
		
		long count = calculationService.getCount(equipmentListEquippableThief);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that thief can equip found.");
		} else {
			return equipmentListEquippableThief;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment that can be worn by pirates
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by pirates
	 * @throws NoneFoundException if no equipment in the database can be worn by pirates
	 */
	public Iterable<Equipment> getAllEquipablePirate() {
		var equipmentListEquippablePirate = equipmentRepository.findAllByPirate(1);
		
		long count = calculationService.getCount(equipmentListEquippablePirate);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that pirate can equip found.");
		} else {
			return equipmentListEquippablePirate;
		}
	}
	
	/*
	 * Service method that returns a collection of equipment that can be worn by all jobs
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by all jobs
	 * @throws NoneFoundException if no equipment in the database can be worn by all jobs
	 */
	public Iterable<Equipment> getAllEquipableCommon() {
		var equipmentListEquippableAll = equipmentRepository.findAllByCommon(1);
		
		long count = calculationService.getCount(equipmentListEquippableAll);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that all jobs can equip found.");
		} else {
			return equipmentListEquippableAll;
		}
	}
}
