package com.artaleDB.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/mobs/{mobName:[a-zA-Z &.]*}")
	public List<MobDrops> getAllFromMobName(@PathVariable String mobName) {
		return dropService.findAllFromGivenMob(mobName);
	}
	
	@GetMapping("/mobs/{equipmentName:[a-zA-Z &.]*}")
	public List<MobDrops> getAllMobWhoDropEquipment(@PathVariable String equipmentName) {
		return dropService.findAllMobThatDropGivenEquipment(equipmentName);
	}
	
	//Boss Drops
	
	@GetMapping("/boss")
	public List<BossDrops> getAllBoss() {
		return dropService.findAllBossDrops();
	}
	
	@GetMapping("/boss/{bossName:[a-zA-Z &.]*}")
	public List<BossDrops> getAllFromBossName(@PathVariable String bossName) {
		return dropService.findAllFromGivenBoss(bossName);
	}
	
	@GetMapping("/boss/{equipmentName:[a-zA-Z &.]*}")
	public List<BossDrops> getAllBossWhoDropEquipment(@PathVariable String equipmentName) {
		return dropService.findAllBossThatDropGivenEquipment(equipmentName);
	}
}
