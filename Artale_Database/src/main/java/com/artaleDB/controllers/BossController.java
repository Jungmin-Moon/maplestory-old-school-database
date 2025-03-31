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
import com.artaleDB.services.BossService;

@RestController
@RequestMapping("boss")
public class BossController {
	
	BossService bossService;
	
	
	BossController(BossService bossService) {
		this.bossService = bossService;
	}
	
	
	@GetMapping
	public Iterable<Boss> getAll() {
		return bossService.viewBossList();
	}
	
	@GetMapping("/{name:[a-zA-Z &.]*}")
	public Iterable<Boss> findByName(@PathVariable String name) {
		return bossService.findByName(name);
	}
	
	@GetMapping("/list/{name:[a-zA-Z &.]*}")
	public Iterable<Boss> findByPartialMatch(@PathVariable String name) {
		return bossService.findByPartialMatch(name);
	}
	
	@GetMapping("/location/{location:[a-zA-Z ]*}")
	public Iterable<Boss> findByLocation(@PathVariable String location) {
		return bossService.findByLocation(location);
	}
	
	@GetMapping("/level/{level}") 
	public Iterable<Boss> findByLevel(@PathVariable int level) {
		return bossService.findByBossLevel(level);
	}
	
	@GetMapping("/level/asc") 
	public Iterable<Boss> getAllLevelAsc() {
		return bossService.findAllBossLevelAsc();
	}
	
	@GetMapping("/level/desc")
	public Iterable<Boss> getAllLevelDesc() {
		return bossService.findAllBossLevelDesc();
	}
	
	@GetMapping("/hp/asc")
	public Iterable<Boss> getAllHPAsc() {
		return bossService.findAllBossHPAsc();
	}
	
	@GetMapping("/hp/desc")
	public Iterable<Boss> getAllHPDesc() {
		return bossService.findAllBossHPDesc();
	}
	
	@GetMapping("/respawn/min/{timer}")
	public Iterable<Boss> getAllMinRespawnGreater(@PathVariable int timer) {
		return bossService.findAllBossMinRespawnGreater(timer);
	}
	
	@GetMapping("/respawn/max/{timer}")
	public Iterable<Boss> getAllMaxRespawnGreater(@PathVariable int timer) {
		return bossService.findAllBossMaxRespawnGreater(timer);
	}
	
	@GetMapping("/respawn/max/asc")
	public Iterable<Boss> getAllMaxRespawnAsc() {
		return bossService.findAllBossMaxRespawnAsc();
	}
	
	@GetMapping("/respawn/max/desc")
	public Iterable<Boss> getAllMaxRespawnDesc() {
		return bossService.findAllBossMaxRespawnDesc();
	}
	
	@GetMapping("/respawn/min/asc")
	public Iterable<Boss> getAllMinRespawnAsc() {
		return bossService.findAllBossMinRespawnAsc();
	}
	
	@GetMapping("/respawn/min/desc")
	public Iterable<Boss> getAllMinRespawnDesc() {
		return bossService.findAllBossMinRespawnDesc();
	}
}
