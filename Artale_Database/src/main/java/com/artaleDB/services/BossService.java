package com.artaleDB.services;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Boss;
import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.BossRepository;

@Service
public class BossService {

	BossRepository bossRepo;
	
	BossService(BossRepository bossRepo) {
		this.bossRepo = bossRepo;	
	}
	
	public Iterable<Boss> viewBossList() {
		return bossRepo.findAll();
	}
	
	public Iterable<Boss> findByName(String name) {
		Iterable<Boss> checkName = bossRepo.findByName(name);
		long count = StreamSupport.stream(checkName.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses were found with the name: " + name + " in the database.");
		} else {
			return checkName;
		}
	}
	
	public Iterable<Boss> findByPartialMatch(String name) {
		Iterable<Boss> checkNames = bossRepo.findByPartialMatch(name);
		long count = StreamSupport.stream(checkNames.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses were found similar to the name: " + name + " in the database.");
		} else {
			return checkNames;
		}
	}
	
	public Iterable<Boss> findByLocation(String location) {
		Iterable<Boss> checkLocation = bossRepo.findByBossLocation(location);
		long count = StreamSupport.stream(checkLocation.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoMatchingLocationException("No bosses found in the location: " + location + " in the database.");
			
		} else {
			return checkLocation;
		}
	}
	
	public Iterable<Boss> findByBossLevel(int level) {
		Iterable<Boss> checkLevel = bossRepo.findByBossLevelEquals(level);
		long count = StreamSupport.stream(checkLevel.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with the level: " + level + " in the database.");
		} else {
			return checkLevel;
		}
	}
	
	public Iterable<Boss> findAllBossLevelAsc() {
		Iterable<Boss> levelsAsc = bossRepo.findAllByOrderByBossLevelAsc();
		long count = StreamSupport.stream(levelsAsc.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found in the database.");
		} else {
			return levelsAsc;
		}
	}
	
	public Iterable<Boss> findAllBossLevelDesc() {
		Iterable<Boss> levelsDesc = bossRepo.findAllByOrderByBossLevelDesc();
		long count = StreamSupport.stream(levelsDesc.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found in the database.");
		} else {
			return levelsDesc;
		}
	}
	
	public Iterable<Boss> findAllBossHPAsc() {
		Iterable<Boss> hpAsc = bossRepo.findAllByOrderByBossHPAsc();
		long count = StreamSupport.stream(hpAsc.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found in the database.");
		} else {
			return hpAsc;
		}
	}
	
	public Iterable<Boss> findAllBossHPDesc() {
		Iterable<Boss> hpDesc = bossRepo.findAllByOrderByBossHPDesc();
		long count = StreamSupport.stream(hpDesc.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found in the database.");
		} else {
			return hpDesc;
		}
	}
	
	public Iterable<Boss> findAllBossMinRespawnGreater(int respawnTime) {
		Iterable<Boss> minRespawnGreater = bossRepo.findAllByBossMinRespawnGreaterThanEqual(respawnTime);
		long count = StreamSupport.stream(minRespawnGreater.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with minimum respawn greater than: " + respawnTime + " in the database.");
		} else {
			return minRespawnGreater;
		}
	}
	
	public Iterable<Boss> findAllBossMaxRespawnGreater(int respawnTime) {
		Iterable<Boss> maxRespawnGreater = bossRepo.findAllByBossMaxRespawnGreaterThanEqual(respawnTime);
		long count = StreamSupport.stream(maxRespawnGreater.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with maximum respawn greater than: " + respawnTime + " in the dabatase.");
		} else {
			return maxRespawnGreater;
		}
	}
	
	public Iterable<Boss> findAllBossMinRespawnAsc() {
		Iterable<Boss> minRespawnAsc = bossRepo.findAllByOrderByBossMinRespawnAsc();
		long count = StreamSupport.stream(minRespawnAsc.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found in the database.");
		} else {
			return minRespawnAsc;
		}
	}
}	
