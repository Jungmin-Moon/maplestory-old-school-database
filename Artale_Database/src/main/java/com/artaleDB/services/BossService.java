package com.artaleDB.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Boss;
import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.BossRepository;

@Service
public class BossService {

	BossRepository bossRepo;
	CalculationService calculationService;
	
	BossService(BossRepository bossRepo, CalculationService calculationService) {
		this.bossRepo = bossRepo;
		this.calculationService = calculationService;
	}
	
	public Iterable<Boss> viewBossList() {
		return bossRepo.findAll();
	}
	
	public Optional<Boss> findByName(String name) {
		Optional<Boss> bossByName = bossRepo.findByName(name);
		
		if (bossByName == null) {
			throw new NoneFoundException("No bosses were found with the name: " + name + " in the database.");
		} else {
			return bossByName;
		}
	}
	
	public Iterable<Boss> findByPartialMatch(String name) {
		Iterable<Boss> bossListByPartialMatch = bossRepo.findByPartialMatch(name);
		
		long count = calculationService.getCount(bossListByPartialMatch);
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses were found similar to the name: " + name + " in the database.");
		} else {
			return bossListByPartialMatch;
		}
	}
	
	public Iterable<Boss> findByLocation(String location) {
		Iterable<Boss> bossListByLocation = bossRepo.findByBossLocation(location);
		
		long count = calculationService.getCount(bossListByLocation);
		
		if (count <= 0) {
			throw new NoMatchingLocationException("No bosses found in the location: " + location + " in the database.");
			
		} else {
			return bossListByLocation;
		}
	}
	
	public Iterable<Boss> findByBossLevel(int level) {
		Iterable<Boss> bossListByLevelEqual = bossRepo.findByBossLevelEquals(level);
		
		long count = calculationService.getCount(bossListByLevelEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with the level: " + level + " in the database.");
		} else {
			return bossListByLevelEqual;
		}
	}
	
	public Iterable<Boss> findAllBossMinRespawnGreater(int respawnTime) {
		Iterable<Boss> bossListMinRepsawnGreaterEqual = bossRepo.findAllByBossMinRespawnGreaterThanEqual(respawnTime);
		
		long count = calculationService.getCount(bossListMinRepsawnGreaterEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with minimum respawn greater than: " + respawnTime + " in the database.");
		} else {
			return bossListMinRepsawnGreaterEqual;
		}
	}
	
	public Iterable<Boss> findAllBossMaxRespawnGreater(int respawnTime) {
		Iterable<Boss> bossListMaxRespawnGreaterEqual = bossRepo.findAllByBossMaxRespawnGreaterThanEqual(respawnTime);
		
		long count = calculationService.getCount(bossListMaxRespawnGreaterEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with maximum respawn greater than: " + respawnTime + " in the dabatase.");
		} else {
			return bossListMaxRespawnGreaterEqual;
		}
	}
}	
