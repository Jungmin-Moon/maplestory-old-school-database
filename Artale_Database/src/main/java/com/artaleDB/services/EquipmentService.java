package com.artaleDB.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Equipment;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.EquipmentRepository;

@Service
public class EquipmentService {
	
	EquipmentRepository equipmentRepository;
	
	public EquipmentService(EquipmentRepository equipmentRepository) {
		this.equipmentRepository = equipmentRepository;
	}
	
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
	
	public Iterable<Equipment> getEquipmentByType(String equipmentType) {
		return equipmentRepository.findByEquipmentType(equipmentType);
	}
	
	public Iterable<Equipment> getAllByWeaponType(String weaponType) {
		return equipmentRepository.findByWeaponType(weaponType);
	}
	
	public Iterable<Equipment> getAllByArmorType(String armorType) {
		return equipmentRepository.findByArmorType(armorType);
	}
	
	public Iterable<Equipment> getAllByAccessoryType(String accessoryType) {
		return equipmentRepository.findByAccessoryType(accessoryType);
	}
	
	public Iterable<Equipment> getAllByMinLevelGreaterThanEqual(int level) {
		return equipmentRepository.findAllByMinimumLevelGreaterThanEqual(level);
	}
	
	public Iterable<Equipment> getAllEquipableWarrior() {
		return equipmentRepository.findAllByWarrior(1);
	}
	
	public Iterable<Equipment> getAllEquipableMagician() {
		return equipmentRepository.findAllByMagician(1);
	}
	
	public Iterable<Equipment> getAllEquipableArcher() {
		return equipmentRepository.findAllByArcher(1);
	}
	
	public Iterable<Equipment> getAllEquipableThief() {
		return equipmentRepository.findAllByThief(1);
	}
	
	public Iterable<Equipment> getAllEquipablePirate() {
		return equipmentRepository.findAllByPirate(1);
	}
	
	public Iterable<Equipment> getAllEquipableCommon() {
		return equipmentRepository.findAllByCommon(1);
	}
}
