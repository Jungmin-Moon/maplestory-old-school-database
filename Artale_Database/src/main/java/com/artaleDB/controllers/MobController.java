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

@RestController
@RequestMapping("/api/v1")
public class MobController {
	
	MobRepository mobRepo;
	
	MobController(MobRepository mobRepo) {
		this.mobRepo = mobRepo;
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
	
}
