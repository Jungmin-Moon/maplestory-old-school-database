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
import com.artaleDB.services.ListPrintService;

@RestController
@RequestMapping("/api/v1")
public class MobController {
	
	MobRepository mobRepo;
	CalculationService calcService;
	ListPrintService listPrintService;
	
	MobController(MobRepository mobRepo, CalculationService calcService, ListPrintService listPrintService) {
		this.mobRepo = mobRepo;
		this.calcService = calcService;
		this.listPrintService = listPrintService;
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
	
	@GetMapping("/mobs/name/{name:[a-zA-Z &+-.]*}")
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
	
	@GetMapping("/mobs/hour/{name:[a-zA-Z &+-.]*}/{defeats}")
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
	
	
	@GetMapping("/mobs/location/{location:[a-zA-Z &+-.]*}")
	public ResponseEntity<Object> getMobsFromSpecificLocation(@PathVariable String location) {
		
		List<Mob> mobByLocationList = mobRepo.getByLocations(location);
		
		if (mobByLocationList.size() > 0) {
			return ResponseEntity.status(HttpStatus.FOUND)
								.body(mobRepo.getByLocations(location));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There are no mobs located in that location. Please check to make sure you correctly typed the location.");
		}
		
	}
	//exp
	//combination ones exp, meso, accuracy
	//exp meso
	
	@GetMapping("/mobs/accuracy/desc")
	public ResponseEntity<Object> mobsOrderedByAccDesc() {	
		return ResponseEntity.status(HttpStatus.FOUND)
							.body(mobRepo.getByAccuracyDesc());
	}
	
	@GetMapping("/mobs/accuracy/asc")
	public ResponseEntity<Object> mobsOrderedByAccAsc() {
		return ResponseEntity.status(HttpStatus.FOUND)
							.body(mobRepo.getByAccuracyAsc());
	}
	
	@GetMapping("/mobs/accuracy/asc/{limit}")
	public ResponseEntity<Object> orderedByAccAscWithLimit(@PathVariable int limit) {
		
		List<Mob> mobsAccOrderedByAscLimit = mobRepo.getAccuracyAscLimit(limit);
		
		return ResponseEntity.status(HttpStatus.FOUND)
							.body(listPrintService.printListWithMobNameAndAccuracy(mobsAccOrderedByAscLimit));
	}
	
	@GetMapping("/mobs/accuracy/desc/{limit}")
	public ResponseEntity<Object> orderedByAccDescWithLimit(@PathVariable int limit) {
		
		List<Mob> mobsAccOrderedByDescLimit = mobRepo.getAccuracyDescLimit(limit);
		
		return ResponseEntity.status(HttpStatus.FOUND)
							.body(listPrintService.printListWithMobNameAndAccuracy(mobsAccOrderedByDescLimit));
	}
	
	@GetMapping("/mobs/maxmeso/asc")
	public ResponseEntity<Object> orderedByMaxMesoAsc() {
		
		List<Mob> mobsMaxMesoOrderedAsc = mobRepo.getMaxMesoAsc();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
							.body(listPrintService.printListWithMobNameAndMaxMeso(mobsMaxMesoOrderedAsc));
	}
	
	@GetMapping("/mobs/maxmeso/desc")
	public ResponseEntity<Object> orderedByMaxMesodesc() {
		
		List<Mob> mobsMaxMesoOrderedDesc = mobRepo.getMaxMesoDesc();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED)
							.body(listPrintService.printListWithMobNameAndMaxMeso(mobsMaxMesoOrderedDesc));
	}
	
	
}
