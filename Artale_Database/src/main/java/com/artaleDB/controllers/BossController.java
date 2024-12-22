package com.artaleDB.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Boss;
import com.artaleDB.services.BossService;

@RestController
@RequestMapping("/api/v1/boss")
public class BossController {
	
	BossService bossService;
	
	
	BossController(BossService bossService) {
		this.bossService = bossService;
	}
	
	
	@GetMapping("/all")
	public List<Boss> findAll() {
		return bossRepo.findAll();
	}
	
	
	
}
