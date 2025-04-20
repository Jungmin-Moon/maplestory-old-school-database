package com.artaleDB.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Equipment;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.EquipmentRepository;
/*
 * Service class that handles getting all information from the database and passes it to the controller
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
		return equipmentRepository.findAll();
	}
	
	
	public Optional<Equipment> getEquipmentByName(String name) {
		
		var equipment = equipmentRepository.findAllByEquipmentName(name);
		
		if (equipment == null) {
			throw new NoneFoundException("There is no equipment in the database with that name.");
		} else {
			return equipment;
		}
	}
	
	public Iterable<Equipment> getEquipmentByNamePartialMatch(String subString) {
		var equipmentList = equipmentRepository.findAllByNamePartialmatch(subString);
		
		long count = calculationService.getCount(equipmentList);
		
		if (count <= 0) {
			throw new NoneFoundException("There is no equipment containing this word.");
		} else {
			return equipmentList;
		}
	}
	
	public Iterable<Equipment> getEquipmentByType(String equipmentType) {
		var equipmentListByType = equipmentRepository.findByEquipmentType(equipmentType);
		
		long count = calculationService.getCount(equipmentListByType);
		
		if (count <= 0) {
			throw new NoneFoundException("There is no equipment that are " + equipmentType + " in the database.");
		} else {
			return equipmentListByType;
		}
	}
	
	public Iterable<Equipment> getAllByWeaponType(String weaponType) {
		var equipmentListByWeaponType = equipmentRepository.findByWeaponType(weaponType);
		
		long count = calculationService.getCount(equipmentListByWeaponType);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no weapons of type: " + weaponType + " in the dabatase.");
		} else {
			return equipmentListByWeaponType;
		}
	}
	
	public Iterable<Equipment> getAllByArmorType(String armorType) {
		var equipmentListByArmorType = equipmentRepository.findByArmorType(armorType);
		
		long count = calculationService.getCount(equipmentListByArmorType);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no armor of type: " + armorType + " in the database.");
		} else {
			return equipmentListByArmorType;
		}
	}
	
	public Iterable<Equipment> getAllByAccessoryType(String accessoryType) {
		var equipmentListByAccessoryType = equipmentRepository.findByAccessoryType(accessoryType);
		
		long count = calculationService.getCount(equipmentListByAccessoryType);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no accessories of type: " + accessoryType + " in the database.");
		} else {
			return equipmentListByAccessoryType;
		}
	}
	
	public Iterable<Equipment> getAllByMinLevelGreaterThanEqual(int level) {
		var equipmentListByMinLevel = equipmentRepository.findAllByMinimumLevelGreaterThanEqual(level);
		
		long count = calculationService.getCount(equipmentListByMinLevel);
		
		if (count <= 0) {
			throw new NoneFoundException("There are no equipment with a minimum level " + level + " or higher.");
		} else {
			return equipmentListByMinLevel;
		}
	}
	
	public Iterable<Equipment> getAllEquipableWarrior() {
		var equipmentListEquippableWarrior = equipmentRepository.findAllByWarrior(1);
		
		long count = calculationService.getCount(equipmentListEquippableWarrior);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equiment that warriors can equip found.");
		} else {
			return equipmentListEquippableWarrior;
		}
	}
	
	public Iterable<Equipment> getAllEquipableMagician() {
		var equipmentListEquippableMagician = equipmentRepository.findAllByMagician(1);
		
		long count = calculationService.getCount(equipmentListEquippableMagician);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that magicians can equip found.");
		} else {
			return equipmentListEquippableMagician;
		}
	}
	
	public Iterable<Equipment> getAllEquipableArcher() {
		var equipmentListEquippableArcher = equipmentRepository.findAllByArcher(1);
		
		long count = calculationService.getCount(equipmentListEquippableArcher);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that archers can equip found.");
		} else {
			return equipmentListEquippableArcher;
		}
	}
	
	public Iterable<Equipment> getAllEquipableThief() {
		var equipmentListEquippableThief = equipmentRepository.findAllByThief(1);
		
		long count = calculationService.getCount(equipmentListEquippableThief);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that thief can equip found.");
		} else {
			return equipmentListEquippableThief;
		}
	}
	
	public Iterable<Equipment> getAllEquipablePirate() {
		var equipmentListEquippablePirate = equipmentRepository.findAllByPirate(1);
		
		long count = calculationService.getCount(equipmentListEquippablePirate);
		
		if (count <= 0) {
			throw new NoneFoundException("There were no equipment that pirate can equip found.");
		} else {
			return equipmentListEquippablePirate;
		}
	}
	
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
