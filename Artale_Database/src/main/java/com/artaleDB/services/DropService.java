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
	
	
	public List<MobDrops> findAllMobDrops() {
		var allMobDrops = mobDropRepository.findAll();
		
		long count = calculationService.getCount(allMobDrops);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return mobDropRepository.findAll();
		}
	}
	
	
	public List<BossDrops> findAllBossDrops() {
		var allBossDrops = bossDropRepository.findAll();
		
		long count = calculationService.getCount(allBossDrops);
		
		if (count <= 0) {
			throw new NoneFoundException("The database for drops is currently empty.");
		} else {
			return bossDropRepository.findAll();
		}
	}
}
