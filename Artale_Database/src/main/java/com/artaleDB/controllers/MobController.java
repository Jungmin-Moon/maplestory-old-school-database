package com.artaleDB.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Mob;
import com.artaleDB.services.CalculationService;
import com.artaleDB.services.MobService;

@RestController
@RequestMapping("/api/v1/mobs")
public class MobController {
	
	MobService mobService;
	CalculationService calcService;
	
	MobController(MobService mobService, CalculationService calcService) {
		this.mobService = mobService;
		this.calcService = calcService;
	}
	/*
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
		
		if (mobsByName.size() > 1) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body(mobsByName);
		} else if (mobsByName.size() == 1) {
			return ResponseEntity.status(HttpStatus.FOUND)
								.body(mobsByName);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("No mob with that name.");
		}
		
	}
	
	@GetMapping("/location/{location:[a-zA-Z &+-.]*}")
	public ResponseEntity<Object> mobsByLocation(@PathVariable String location) {
		List<Mob> mobsByLocation = mobService.returnListByLocation(location);
		
		if (mobsByLocation.size() > 1) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body(mobsByLocation);
		} else if (mobsByLocation.size() == 1) {
			return ResponseEntity.status(HttpStatus.FOUND)
								.body(mobsByLocation);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("No mobs in that location.");
		}
	}
	
	@GetMapping("/exp/hour/{name:[a-zA-Z &+-.]*}/{kills}")
	public ResponseEntity<Object> expMesoPerHour(@PathVariable String name, @PathVariable int kills) {
		List<Mob> mobByName = mobService.returnListByName(name);
		
		if (mobByName.size() > 1) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body("There are too many options.");
		} else if (mobByName.size() == 1) {
			BigDecimal expPerHour = calcService.expPerHour(mobByName.get(0).getMobEXP(), kills);
			BigDecimal maxMesoPerHour = calcService.maxMesoPerHour(mobByName.get(0).getMobMaxMeso(), kills);
			BigDecimal minMesoPerHour = calcService.minMesoPerHour(mobByName.get(0).getMobMinMeso(), kills);
			
			return ResponseEntity.status(HttpStatus.OK)
								.body("Your exp per hour is: " + expPerHour + 
										"\nYour max potential meso per hour is: " + maxMesoPerHour +
										"\nYour min potential meso per hour is: " + minMesoPerHour);
			
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
								.body("Unable to do any calculations.");
		}
	}
	
	@GetMapping("/acc/asc")
	public ResponseEntity<Object> mobsByAccAsc() {
		List<Mob> mobsByAccAsc = mobService.returnListByAccuracyAsc();
		
		if (mobsByAccAsc.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByAccAsc);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There are no mobs available.");
		}
	}
	
	@GetMapping("/acc/desc")
	public ResponseEntity<Object> mobsByAccDesc() {
		List<Mob> mobsByAccDesc = mobService.returnListByAccuracyDesc();
		
		if (mobsByAccDesc.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByAccDesc);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There are no mobs available.");
		}
	}
	
	@GetMapping("/acc/asc/{limit}")
	public ResponseEntity<Object> mobsByAccAscWithLimit(@PathVariable int limit) {
		List<Mob> mobsByAccAscLimit = mobService.returnListByAccuracyAscLimit(limit);
		
		if (mobsByAccAscLimit.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByAccAscLimit);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There are no mobs available.");
		}
	}
	
	@GetMapping("/acc/desc/{limit}")
	public ResponseEntity<Object> mobsByAccDescWithLimit(@PathVariable int limit) {
		List<Mob> mobsByAccDescLimit = mobService.returnListByAccuracyDescLimit(limit);
		
		if (mobsByAccDescLimit.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByAccDescLimit);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no information.");
		}
	}
	
	@GetMapping("/meso/max/asc")
	public ResponseEntity<Object> mobsByMaxMesoAsc() {
		List<Mob> mobsByMaxMesoAsc = mobService.returnListByMaxMesoAsc();
		
		if (mobsByMaxMesoAsc.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByMaxMesoAsc);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no information.");
		}
	}
	
	@GetMapping("/meso/max/desc")
	public ResponseEntity<Object> mobsByMaxMesoDesc() {
		List<Mob> mobsByMaxMesoDsc = mobService.returnListByMaxMesoDesc();
		
		if (mobsByMaxMesoDsc.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByMaxMesoDsc);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no information.");
		}
	}
	
	@GetMapping("/meso/min/asc")
	public ResponseEntity<Object> mobsByMinMesoAsc() {
		List<Mob> mobsByMinMesoAsc = mobService.returnListByMinMesoAsc();
		
		if (mobsByMinMesoAsc.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByMinMesoAsc);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no information.");
		}
	}
	
	@GetMapping("/meso/min/desc")
	public ResponseEntity<Object> mobsByMinMesoDesc() {
		List<Mob> mobsByMinMesoDesc = mobService.returnListByMinMesoDesc();
		
		if (mobsByMinMesoDesc.size() > 0) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(mobsByMinMesoDesc);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no information.");
		}
	}

}
