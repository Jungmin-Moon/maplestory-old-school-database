package com.artaleDB.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Mob;
import com.artaleDB.repositories.MobRepository;
import com.artaleDB.services.CalculationService;

@RestController
@RequestMapping("/api/v1")
public class MobController {
	
	MobRepository mobRepo;
	CalculationService calcService;
	
	MobController(MobRepository mobRepo, CalculationService calcService) {
		this.mobRepo = mobRepo;
		this.calcService = calcService;
	}
	
	
	@GetMapping("/mobs/all") 
	public List<Mob> mobFullList() {
		return mobRepo.findAll();
	}
	
	@GetMapping("/mobs/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		Optional<Mob> mob = mobRepo.findById(id);
		
		if (mob.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
								.header("Mob", "Mob ID")
								.body(mobRepo.findById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No such mob exists.");
		}
	}
	
	@GetMapping("/mobs/name/{name:[a-zA-Z &+-]*}")
	public ResponseEntity<Object> findByName(@PathVariable String name) {
		
		List<Mob> mobList = mobRepo.getByName(name);
		
		if (mobList.size() > 0) {
			return ResponseEntity.status(HttpStatus.FOUND)
								.header("Mob", "Mob Name")
								.body(mobRepo.getByName(name));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There are no mobs with that or similar name in the database.");
		}
		
		
	}
	
	@GetMapping("/mobs/hour/{name:[a-zA-Z &+-]*}/{defeats}")
	public ResponseEntity<Object> calculateEXPPerHour(@PathVariable String name, @PathVariable int defeats) {
		
		List<Mob> mobList = mobRepo.getByName(name);
		
		if (mobList.size() > 1) {
			return ResponseEntity.status(HttpStatus.OK)
								.body("Please input a more specific mob name.");
		} else {
			Mob tempMob = mobList.getFirst();
			
			return ResponseEntity.status(HttpStatus.OK)
								.body("The experience per hour is " + calcService.expPerHour(tempMob.getMobEXP(), defeats) + " per hour.");
		
		}
	}
	
}
