package com.artaleDB.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Boss;
import com.artaleDB.repositories.BossRepository;
import com.artaleDB.services.CalculationService;
import com.artaleDB.services.ListPrintService;

@RestController
@RequestMapping("/api/v1/boss")
public class BossController {
	
	BossRepository bossRepo;
	CalculationService calcService;
	ListPrintService listPrintService;
	
	
	BossController(BossRepository bossRepo, CalculationService calcService, ListPrintService listPrintService) {
		this.bossRepo = bossRepo;
		this.calcService = calcService;
		this.listPrintService = listPrintService;
	}
	
	
	@GetMapping("/all")
	public List<Boss> findAll() {
		return bossRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findByBossId(@PathVariable long id) {
		Optional<Boss> boss = bossRepo.findById(id);
		
		if (boss.isPresent()) {
			return ResponseEntity.status(HttpStatus.FOUND)
					.header("Boss", "Boss ID")
					.body(bossRepo.findById(id));
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No such boss exists.");
		}
	}
	
	//location search
	
	@GetMapping("/name/{name:[a-zA-z &+-.]*}")
	public ResponseEntity<Object> findByName(@PathVariable String name) {
		
		List<Boss> bossList = bossRepo.getByName(name);
		
		if (bossList.size() > 1) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body("Results of your search query: \n" + bossRepo.getByName(name));
		} else if(bossList.size() == 1) {
			return ResponseEntity.status(HttpStatus.FOUND)
								.body("Results of your query: \n" + bossRepo.getByName(name));
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
								.body("There are no results for your query. Please try again.");
		}
	}
	
	
	@GetMapping("/location/{location:[a-zA-z &+-.]*}")
	public ResponseEntity<Object> findByLocation(@PathVariable String location) {
		
		List<Boss> bossLocations = bossRepo.getByLocations(location);
		
		if (bossLocations.size() > 0) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body("Results of your query: \n" + bossRepo.getByLocations(location));
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
								.body("There are no results for your query. Please try again.");
		}
	}
	
	
}
