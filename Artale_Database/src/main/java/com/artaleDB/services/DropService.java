package com.artaleDB.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.BossDrops;
import com.artaleDB.entities.MobDrops;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.BossDropRepository;
import com.artaleDB.repositories.MobDropRepository;

@Service
public class DropService {

	MobDropRepository mobDropRepository;
	BossDropRepository bossDropRepository;
	CalculationService calculationService;
	
	DropService(MobDropRepository mobDropRepository, BossDropRepository bossDropRepository, CalculationService calculationService) {
		this.mobDropRepository = mobDropRepository;
		this.bossDropRepository = bossDropRepository;
		this.calculationService = calculationService;
	}
	
	//Mob REST endpoints
	public List<MobDrops> findAllMobDrops() {
		var allMobDrops = mobDropRepository.findAll();
		
		long count = calculationService.getCount(allMobDrops);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return allMobDrops;
		}
	}
	
	public List<MobDrops> findAllFromMob(String mobName) {
		var mobDropsFromGivenMob = mobDropRepository.findAllByMobName(mobName);
		
		long count = calculationService.getCount(mobDropsFromGivenMob);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return mobDropsFromGivenMob;
		}
	}
	
	public List<MobDrops> findAllMobDropEquipment(String equipment) {
		var equipmentDropsFromMob = mobDropRepository.findAllByEquipmentName(equipment);
		
		long count = calculationService.getCount(equipmentDropsFromMob);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return equipmentDropsFromMob;
		}
	}
	
	//Boss REST endpoints
	public List<BossDrops> findAllBossDrops() {
		var allBossDrops = bossDropRepository.findAll();
		
		long count = calculationService.getCount(allBossDrops);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return allBossDrops;
		}
	}
	
	public List<BossDrops> findAllFromBoss(String bossName) {
		var bossDropsFromGivenMob = bossDropRepository.findAllByBossName(bossName);
		
		long count = calculationService.getCount(bossDropsFromGivenMob);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return bossDropsFromGivenMob;
		}
	}
	
	public List<BossDrops> findAllBossDropEquipment(String equipment) {
		var equipmentDropsFromBoss = bossDropRepository.findAllByEquipmentName(equipment);
		
		long count = calculationService.getCount(equipmentDropsFromBoss);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return equipmentDropsFromBoss;
		}
	}
	
	
	//Web endpoints
	public List<MobDrops> findAllMobDropsWeb() {
		return mobDropRepository.findAll();
	}
	
	public List<MobDrops> findAllEquipmentFromMobName(String mobName) {
		return mobDropRepository.findAllByMobName(mobName);
	}
	
	public List<MobDrops> findAllMobsDropEquipmentName(String equipmentName) {
		return mobDropRepository.findAllByEquipmentName(equipmentName);
	}
	
	public List<BossDrops> findAllBossDropsWeb() {
		return bossDropRepository.findAll();
	}
	
	public List<BossDrops> findAllEquipmentFromBossName(String bossName) {
		return bossDropRepository.findAllByBossName(bossName);
	}
	
	public List<BossDrops> findAllBossDropEquipmentName(String equipmentName) {
		return bossDropRepository.findAllByEquipmentName(equipmentName);
	}
	
}
