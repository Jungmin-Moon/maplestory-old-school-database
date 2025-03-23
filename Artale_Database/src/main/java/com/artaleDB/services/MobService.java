package com.artaleDB.services;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Mob;
import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.MobRepository;

@Service
public class MobService {
	
	MobRepository mobRepo;
	
	MobService(MobRepository mobRepo) {
		this.mobRepo = mobRepo;
	}
	
	
	public Iterable<Mob> viewMobList() {
		return mobRepo.findAll();
	}
	
	public Iterable<Mob> findByName(String name) {
		Iterable<Mob> checkCollection = mobRepo.findByName(name);
		
		long count = StreamSupport.stream(checkCollection.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found with name: " + name + " in the database.");
		} else {
			return checkCollection;
		}
	}
	
	public Iterable<Mob> findByPartialMatch(String name) {
		Iterable<Mob> check = mobRepo.findByPartialMatch(name);
		
		if (StreamSupport.stream(check.spliterator(), false).count() > 0) {
			return check;
		} else {
			throw new NoneFoundException("No mobs found that match: " + name + " in the database.");
		}
	}
	
	public Iterable<Mob> findByLocation(String location) {
		Iterable<Mob> checkLocations = mobRepo.findByMobLocation(location);
		
		long count = StreamSupport.stream(checkLocations.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoMatchingLocationException("No mobs found in the location: " + location + " in the database.");
		} else {
			return checkLocations;
		}
	}
	
	public Iterable<Mob> findByLevel(int level) {
		Iterable<Mob> checkLevels = mobRepo.findByMobLevelEquals(level);
		
		long count = StreamSupport.stream(checkLevels.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found with the level: " + level + " in the database,");
		} else {
			return checkLevels;
		}
	}
	
	public Iterable<Mob> findByLevelAsc() {
		Iterable<Mob> levelAscList = mobRepo.findAllByOrderByMobLevelAsc();
		long count = StreamSupport.stream(levelAscList.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found in the database.");
		} else {
			return levelAscList;
		}
	} 
	
	public Iterable<Mob> findByLevelDesc() {
		Iterable<Mob> levelDescList =  mobRepo.findAllByOrderByMobLevelDesc();
		long count = StreamSupport.stream(levelDescList.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found in the database.");
		} else {
			return levelDescList;
		}
	}
	
	public Iterable<Mob> findByExpAsc() {
		Iterable<Mob> expAsc = mobRepo.findAllByOrderByMobEXPAsc();
		long count = StreamSupport.stream(expAsc.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found in the database.");
		} else {
			return expAsc;
		}
	}
	
	public Iterable<Mob> findByExpDesc() {
		Iterable<Mob> expDesc = mobRepo.findAllByOrderByMobEXPDesc();
		long count = StreamSupport.stream(expDesc.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found in the database.");
		} else {
			return expDesc;
		}
	}
	
	public Iterable<Mob> findByMobExpGreater(int exp) {
		Iterable<Mob> expGreater = mobRepo.findAllByMobEXPGreaterThanEqual(exp);
		long count = StreamSupport.stream(expGreater.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs that give exp greater than " + exp + " found in the database.");
		} else {
			return expGreater;
		}
	}
	
	public Iterable<Mob> findByMobExp(int exp) {
		Iterable<Mob> expEqual = mobRepo.findAllByMobEXP(exp);
		long count = StreamSupport.stream(expEqual.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs that give exp: " + exp + " found in the database.");
		} else {
			return expEqual;
		}
	}
	
	public Iterable<Mob> findMinMesoGreater(int minMeso) {
		Iterable<Mob> minMesoGreater = mobRepo.findAllByMobMinMesoGreaterThanEqual(minMeso);
		long count = StreamSupport.stream(minMesoGreater.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found that drop higher minimum meso than " + minMeso + " found in the database.");
		} else {
			return minMesoGreater;
		}
	}
	
	public Iterable<Mob> findMaxMesoGreater(int maxMeso) {
		Iterable<Mob> maxMesoGreater = mobRepo.findAllByMobMaxMesoGreaterThanEqual(maxMeso);
		long count = StreamSupport.stream(maxMesoGreater.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found that drop higher maximum meso than " + maxMeso + " found in the database.");
		} else {
			return maxMesoGreater;
		}
	}
}
