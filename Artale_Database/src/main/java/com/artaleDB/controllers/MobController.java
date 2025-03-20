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
	
	

}
