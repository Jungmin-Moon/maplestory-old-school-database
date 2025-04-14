package com.artaleDB.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Equipment;
import com.artaleDB.services.EquipmentService;

@RestController
@RequestMapping("equipment")
public class EquipmentController {
	
	
	EquipmentService equipmentService;
	
	public EquipmentController(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}
	
	
	@GetMapping
	public Iterable<Equipment> getAll() {
		return equipmentService.getAllEquipment();
	}
	
	@GetMapping("/{name:[a-zA-Z0-9 &.'-]*}")
	public Optional<Equipment> findByName(@PathVariable String name) {
		return equipmentService.getEquipmentByName(name);
	}
	
	@GetMapping("/list/{name:[a-zA-Z0-9 &.'-]*}")
	public Iterable<Equipment> getAllByPartialMatch(@PathVariable String name) {
		return equipmentService.getEquipmentByNamePartialMatch(name);
	}
	
	@GetMapping("/list/equipment/{equipmentType:[a-zA-Z]*}")
	public Iterable<Equipment> getAllByType(@PathVariable String equipmentType) {
		return equipmentService.getEquipmentByType(equipmentType);
	}
	
	@GetMapping("/list/weapons/{weaponType:[a-zA-Z ]*}")
	public Iterable<Equipment> getAllByWeaponType(@PathVariable String weaponType) {
		return equipmentService.getAllByWeaponType(weaponType);
	}
	
	@GetMapping("/list/armors/{armorType:[a-ZA-Z]*}")
	public Iterable<Equipment> getAllByArmorType(@PathVariable String armorType) {
		return equipmentService.getAllByArmorType(armorType);
	}
	
	@GetMapping("/list/accessories/{accessoryType:[a-zA-Z ]*}")
	public Iterable<Equipment> getAllByAccessoryType(@PathVariable String accessoryType) {
		return equipmentService.getAllByAccessoryType(accessoryType);
	}
	
	@GetMapping("/list/level/{level}") 
	public Iterable<Equipment> getAllMinLevelGreaterEqual(@PathVariable int level) {
		return equipmentService.getAllByMinLevelGreaterThanEqual(level);
	}
	
	@GetMapping("/list/warrrior")
	public Iterable<Equipment> getAllWarriorEquippable() {
		return equipmentService.getAllEquipableWarrior();
	}
	
	@GetMapping("/list/magician")
	public Iterable<Equipment> getAllMagicianEquippable() {
		return equipmentService.getAllEquipableMagician();
	}
	
	@GetMapping("/list/archer")
	public Iterable<Equipment> getAllArcherEquippable() {
		return equipmentService.getAllEquipableArcher();
	}
	
	@GetMapping("/list/thief")
	public Iterable<Equipment> getAllThiefEquippable() {
		return equipmentService.getAllEquipableThief();
	}
	
	@GetMapping("/list/pirate")
	public Iterable<Equipment> getAllPirateEquippable() {
		return equipmentService.getAllEquipablePirate();
	}
	
	@GetMapping("/list/common")
	public Iterable<Equipment> getAllCommonEquippable() {
		return equipmentService.getAllEquipableCommon();
	}

}
