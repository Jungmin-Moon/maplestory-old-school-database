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
	
	@GetMapping("/{name:[a-zA-Z &.]*}")
	public Iterable<Mob> findByName(@PathVariable String name) {
		return mobService.findByName(name);
	}
	
	@GetMapping("/list/{name:[a-zA-Z &.]*}") 
	public Iterable<Mob> findByPartialMatch(@PathVariable String name) {
		return mobService.findByPartialMatch(name);
	}
	
	@GetMapping("/location/{location:[a-zA-Z ]*}")
	public Iterable<Mob> findByLocation(@PathVariable String location) {
		return mobService.findByLocation(location);
	}
	
	@GetMapping("/level/{level}")
	public Iterable<Mob> findBylevel(@PathVariable int level) {
		return mobService.findByLevel(level);
	}
	
	@GetMapping("/asc/level")
	public Iterable<Mob> orderByLevelAsc() {
		return mobService.findByLevelAsc();
	}
	
	@GetMapping("/desc/level")
	public Iterable<Mob> orderByLevelDesc() {
		return mobService.findByLevelDesc();
	}
	
	@GetMapping("/asc/exp")
	public Iterable<Mob> orderByExpAsc() {
		return mobService.findByExpAsc();
	}
	
	@GetMapping("/desc/exp")
	public Iterable<Mob> orderByExpDesc() {
		return mobService.findByExpDesc();
	}
	
	@GetMapping("/exp/{exp}") 
	public Iterable<Mob> findByEXP(@PathVariable int exp) {
		return mobService.findByMobExp(exp);
	}
	
	@GetMapping("/min/exp/{exp}")
	public Iterable<Mob> findByGreaterExp(@PathVariable int exp) {
		return mobService.findByMobExpGreater(exp);
	}
	
	@GetMapping("/min/meso/{meso}") 
	public Iterable<Mob> findMinMesoHigher(@PathVariable int meso) {
		return mobService.findMinMesoGreater(meso);
	}
	
	@GetMapping("/max/meso/{meso}")
	public Iterable<Mob> findMaxMesoHigher(@PathVariable int meso) {
		return mobService.findMaxMesoGreater(meso);
	}
}
