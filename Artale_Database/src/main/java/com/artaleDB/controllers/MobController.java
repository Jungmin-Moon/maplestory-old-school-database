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
@RequestMapping("mobs")
public class MobController {
	
	MobService mobService;
	CalculationService calcService;
	
	MobController(MobService mobService, CalculationService calcService) {
		this.mobService = mobService;
		this.calcService = calcService;
	}
	
	@GetMapping
	public Iterable<Mob> get() {
		return mobService.viewMobList();
	}
	
	@GetMapping("{name:[a-zA-Z &.]*}")
	public Mob findByName(@PathVariable String name) {
		return mobService.findByName(name);
	}
	
	@GetMapping("/list/{name:[a-zA-Z &.]*}") 
	public Iterable<Mob> findByPartialMatch(@PathVariable String name) {
		return mobService.findByPartialMatch(name);
	}
}
