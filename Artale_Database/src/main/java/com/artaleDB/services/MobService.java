package com.artaleDB.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Mob;
import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.MobRepository;

@Service
public class MobService {
	
	MobRepository mobRepo;
	CalculationService calculationService;
	
	MobService(MobRepository mobRepo, CalculationService calculationService) {
		this.mobRepo = mobRepo;
		this.calculationService = calculationService;
	}
	
	
	public Iterable<Mob> viewMobList() {
		return mobRepo.findAll();
	}
	
	public Optional<Mob> findByName(String name) {
		Optional<Mob> potentialMobExist = mobRepo.findByName(name);
		
		if (potentialMobExist == null) {
			throw new NoneFoundException("No mobs found with name: " + name + " in the database.");
		} else {
			return potentialMobExist;
		}
	}
	
	public Iterable<Mob> findByPartialMatch(String name) {
		Iterable<Mob> mobListPartialNameMatch = mobRepo.findByPartialMatch(name);
		
		long count = calculationService.getCount(mobListPartialNameMatch);
		
		if (count > 0) {
			return mobListPartialNameMatch;
		} else {
			throw new NoneFoundException("No mobs found that match: " + name + " in the database.");
		}
	}
	
	public Iterable<Mob> findByLocation(String location) {
		Iterable<Mob> mobListByLocations = mobRepo.findByMobLocation(location);
		
		long count = calculationService.getCount(mobListByLocations);
		
		if (count <= 0) {
			throw new NoMatchingLocationException("No mobs found in the location: " + location + " in the database.");
		} else {
			return mobListByLocations;
		}
	}
	
	public Iterable<Mob> findByLevel(int level) {
		Iterable<Mob> mobListByLevel = mobRepo.findByMobLevelEquals(level);
		
		long count = calculationService.getCount(mobListByLevel);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found with the level: " + level + " in the database,");
		} else {
			return mobListByLevel;
		}
	}
	
	public Iterable<Mob> findByMobExpGreater(int exp) {
		Iterable<Mob> mobListExpGreaterThanEqual = mobRepo.findAllByMobEXPGreaterThanEqual(exp);
		
		long count = calculationService.getCount(mobListExpGreaterThanEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs that give exp greater than " + exp + " found in the database.");
		} else {
			return mobListExpGreaterThanEqual;
		}
	}
	
	public Iterable<Mob> findByMobExp(int exp) {
		Iterable<Mob> mobListExpEqual = mobRepo.findAllByMobEXP(exp);
		
		long count = calculationService.getCount(mobListExpEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs that give exp: " + exp + " found in the database.");
		} else {
			return mobListExpEqual;
		}
	}
	
	public Iterable<Mob> findMinMesoGreater(int minMeso) {
		Iterable<Mob> mobListMinMesoGreaterEqual = mobRepo.findAllByMobMinMesoGreaterThanEqual(minMeso);
		
		long count = calculationService.getCount(mobListMinMesoGreaterEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found that drop higher minimum meso than " + minMeso + " found in the database.");
		} else {
			return mobListMinMesoGreaterEqual;
		}
	}
	
	//test to make sure things worked
	public Iterable<Mob> findMaxMesoGreater(int maxMeso) {
		Iterable<Mob> mobListMaxMesoGreaterEqual = mobRepo.findAllByMobMaxMesoGreaterThanEqual(maxMeso);
		
		long count = calculationService.getCount(mobListMaxMesoGreaterEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found that drop higher maximum meso than " + maxMeso + " found in the database.");
		} else {
			return mobListMaxMesoGreaterEqual;
		}
	}
}
