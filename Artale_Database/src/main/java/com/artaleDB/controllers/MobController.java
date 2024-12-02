package com.artaleDB.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Mob;
import com.artaleDB.repositories.MobRepository;

@RestController
@RequestMapping("/mobs")
public class MobController {
	
	MobRepository mobRepo;
	
	MobController(MobRepository mobRepo) {
		this.mobRepo = mobRepo;
	}
	
	
	@GetMapping("/all") 
	public List<Mob> mobFullList() {
		return mobRepo.findAll();
	}
	
	
	
}
