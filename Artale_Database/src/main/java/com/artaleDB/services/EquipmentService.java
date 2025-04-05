package com.artaleDB.services;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Equipment;
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
	
	
}
