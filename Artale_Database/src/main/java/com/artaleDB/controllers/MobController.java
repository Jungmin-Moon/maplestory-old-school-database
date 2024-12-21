package com.artaleDB.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.artaleDB.entities.Mob;
import com.artaleDB.services.MobService;

@RestController
@RequestMapping("/api/v1/mobs")
public class MobController {
	
	MobService mobService;
	
	MobController(MobService mobService) {
		this.mobService = mobService;
	}
	
	//get exp per hour with min and max meso
	/*
	 * location {location:[a-zA-Z &+-.]*}
	 * accuracy des|asc and asc|desc but with a limit
	 * same with meso like accuracy
	 */
	
	@GetMapping("/all") 
	public List<Mob> mobFullList() {
		return mobService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> mobById(@PathVariable long id) {
		
		Optional<Mob> mobId = mobService.returnById(id);
		
		if (mobId.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
								.body(mobService.returnById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("No information.");
		}
	}
	
	
	@GetMapping("/name/{name:[a-zA-Z &+-.]*}") 
	public ResponseEntity<Object> mobByname(@PathVariable String name) {
		
		List<Mob> mobsByName = mobService.returnListByName(name);
		
		if (mobsByName.size() > 0) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body(mobsByName);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("No mob with that name.");
		}
		
	}
	
	
	
	
}
