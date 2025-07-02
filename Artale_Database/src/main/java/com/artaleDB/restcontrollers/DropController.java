package com.artaleDB.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.BossDrops;
import com.artaleDB.entities.MobDrops;
import com.artaleDB.services.DropService;

@RestController
@RequestMapping("drops")
public class DropController {

	DropService dropService;
	
	DropController(DropService dropService) {
		this.dropService = dropService;
	}
	
	//Mob Drops
	
	@GetMapping("/mobs")
	public List<MobDrops> getAllMobs() {
		return dropService.findAllMobDrops();
	}
	
	
	//Boss Drops
	
	@GetMapping("/boss")
	public List<BossDrops> getAllBoss() {
		return dropService.findAllBossDrops();
	}
	
	
}
