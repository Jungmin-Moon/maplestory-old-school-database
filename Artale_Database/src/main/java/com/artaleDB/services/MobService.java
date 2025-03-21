package com.artaleDB.services;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Mob;
import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoMobsFoundException;
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
			throw new NoMobsFoundException(name);
		} else {
			return checkCollection;
		}
	}
	
	public Iterable<Mob> findByPartialMatch(String name) {
		Iterable<Mob> check = mobRepo.findByPartialMatch(name);
		
		if (StreamSupport.stream(check.spliterator(), false).count() > 0) {
			return check;
		} else {
			throw new NoMobsFoundException(name);
		}
	}
	
	public Iterable<Mob> findByLocation(String location) {
		Iterable<Mob> checkLocations = mobRepo.findByMobLocation(location);
		
		long count = StreamSupport.stream(checkLocations.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoMatchingLocationException(location);
		} else {
			return checkLocations;
		}
	}
	
	public Iterable<Mob> findByLevel(int level) {
		Iterable<Mob> checkLevels = mobRepo.findByMobLevelEquals(level);
		
		long count = StreamSupport.stream(checkLevels.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoMobsFoundException(level);
		} else {
			return checkLevels;
		}
	}
	
	public Iterable<Mob> findByLevelAsc() {
		return mobRepo.findAllByOrderByMobLevelAsc();
	} 
	
	public Iterable<Mob> findByLevelDesc() {
		return mobRepo.findAllByOrderByMobLevelDesc();
	}
}
