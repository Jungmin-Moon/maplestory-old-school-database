package com.artaleDB.restcontrollers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Equipment;
import com.artaleDB.services.EquipmentService;
/*
 * RestController that hosts the endpoints related to Equipment in Artale. Data is returned formatted in JSON.
 */
@RestController
@RequestMapping("equipment")
public class EquipmentController {
	
	
	EquipmentService equipmentService;
	
	public EquipmentController(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}
	
	/*
	 * Method that returns all equipment and all their details in JSON format
	 * 
	 * @return Iterable<Equipment> a collection of all equipment in the database
	 */
	@GetMapping
	public Iterable<Equipment> getAll() {
		return equipmentService.getAllEquipment();
	}
	
	/*
	 * Method that returns equipment with the same name as the parmeter
	 * 
	 * @param name represents the name of the equipment to search for in the database
	 * @return Optional<Equipment> if there is an equipment with the same name as the parameter in the database
	 * @throws NoneFoundException if no equipment that matches the parameter is in the database
	 */
	@GetMapping("/{name:[a-zA-Z0-9 &.'-]*}")
	public Optional<Equipment> findByName(@PathVariable String name) {
		return equipmentService.getEquipmentByName(name);
	}
	
	/*
	 * Method that returns a collection of equipment whose name contains the substring
	 * 
	 * @param substring represents the substring to check if the equipment name contains it
	 * @return Iterable<Equipment> if there are equipment in the database that contain the substring in their name
	 * @throws NoneFoundException if no equipment containing the substring in their name exists
	 */
	@GetMapping("/list/{substring:[a-zA-Z0-9 &.'-]*}")
	public Iterable<Equipment> getAllByPartialMatch(@PathVariable String substring) {
		return equipmentService.getEquipmentByNamePartialMatch(substring);
	}
	
	/*
	 * Method that returns a collection of equipment whose equipment type is that of the parameter
	 * 
	 * @param equipmentType represents what type of equipment the user is searching for
	 * @return Iterable<Equipment> a collection of equipment whose equipment type is equal to the parameter
	 * @throws NoneFoundException if no equipment can be found with the same equipment type
	 */
	@GetMapping("/list/equipment/{equipmentType:[a-zA-Z]*}")
	public Iterable<Equipment> getAllByType(@PathVariable String equipmentType) {
		return equipmentService.getEquipmentByType(equipmentType);
	}
	
	/*
	 * Method that returns a collection of equipment whose weapon type is that of the parameter
	 * 
	 * @param weaponType represents what type of weapon the user is searching for
	 * @return Iterable<Equipment> a collection of equipment whose weapon type is equal to the parameter
	 * @throws NoneFoundException if no equipment can be found with the same weapon type
	 */
	@GetMapping("/list/weapons/{weaponType:[a-zA-Z ]*}")
	public Iterable<Equipment> getAllByWeaponType(@PathVariable String weaponType) {
		return equipmentService.getAllByWeaponType(weaponType);
	}
	
	/*
	 * Method that returns a collection of equipment whose armor type is that of the parameter
	 * 
	 * @param armorType represents what type of armor the user is searching for
	 * @return Iterable<Equipment> a collection of equipment whose armor type is equal to the parameter
	 * @throws NoneFoundException if no equipment can be found with the same armor type
	 */
	@GetMapping("/list/armors/{armorType:[a-zA-Z]*}")
	public Iterable<Equipment> getAllByArmorType(@PathVariable String armorType) {
		return equipmentService.getAllByArmorType(armorType);
	}
	
	/*
	 * Method that returns a collection of equipment whose accessory type is that of the parameter
	 * 
	 * @param accessoryType represents what type of accessory the user is searching for
	 * @return Iterable<Equipment> a collection of equipment whose accessory type is equal to the parameter
	 * @throws NoneFoundException if no equipment can be found with the same accessory type
	 */
	@GetMapping("/list/accessories/{accessoryType:[a-zA-Z ]*}")
	public Iterable<Equipment> getAllByAccessoryType(@PathVariable String accessoryType) {
		return equipmentService.getAllByAccessoryType(accessoryType);
	}
	
	/*
	 * Method that returns a collection of equipment whose minimum level is equal or higher than the parameter
	 * 
	 * @param level an int value representing the minimum level the user wants to see gear start from
	 * @return Iterable<Equipment> a collection of equipment whose level is equal to or greater than the parameter
	 * @throws NoneFoundException if no equipment can be found who have a minimum level equal to or greater than the parameter
	 */
	@GetMapping("/list/level/{level}") 
	public Iterable<Equipment> getAllMinLevelGreaterEqual(@PathVariable int level) {
		return equipmentService.getAllByMinLevelGreaterThanEqual(level);
	}
	
	/*
	 * Method that returns a collection of equipment that can be worn by warriors
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by warriors
	 * @throws NoneFoundException if no equipment can be found that can be worn by warriors
	 */
	@GetMapping("/list/warrrior")
	public Iterable<Equipment> getAllWarriorEquippable() {
		return equipmentService.getAllEquipableWarrior();
	}
	
	/*
	 * Method that returns a collection of equipment that can be worn by magicians
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by magicians
	 * @throws NoneFoundException if no equipment can be found that can be worn by magicians
	 */
	@GetMapping("/list/magician")
	public Iterable<Equipment> getAllMagicianEquippable() {
		return equipmentService.getAllEquipableMagician();
	}
	
	/*
	 * Method that returns a collection of equipment that can be worn by archers
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by archers
	 * @throws NoneFoundException if no equipment can be found that can be worn by archers
	 */
	@GetMapping("/list/archer")
	public Iterable<Equipment> getAllArcherEquippable() {
		return equipmentService.getAllEquipableArcher();
	}
	
	/*
	 * Method that returns a collection of equipment that can be worn by thieves
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by thieves
	 * @throws NoneFoundException if no equipment can be found that can be worn by thieves
	 */
	@GetMapping("/list/thief")
	public Iterable<Equipment> getAllThiefEquippable() {
		return equipmentService.getAllEquipableThief();
	}
	
	/*
	 * Method that returns a collection of equipment that can be worn by pirates
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by pirates
	 * @throws NoneFoundException if no equipment can be found that can be worn by pirates
	 */
	@GetMapping("/list/pirate")
	public Iterable<Equipment> getAllPirateEquippable() {
		return equipmentService.getAllEquipablePirate();
	}
	
	/*
	 * Method that returns a collection of equipment that can be worn by all jobs
	 * 
	 * @return Iterable<Equipment> a collection of equipment that can be worn by all jobs
	 * @throws NoneFoundException if no equipment can be found that can be worn by all jobs
	 */
	@GetMapping("/list/common")
	public Iterable<Equipment> getAllCommonEquippable() {
		return equipmentService.getAllEquipableCommon();
	}

}
