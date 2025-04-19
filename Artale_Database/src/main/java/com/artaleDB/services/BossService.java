package com.artaleDB.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Boss;
import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.BossRepository;
/*
 * Service class to handle communication between BossController and the database and then returns the result back to BossController
 * All results are formatted in JSON
 */
@Service
public class BossService {

	BossRepository bossRepo;
	CalculationService calculationService;
	
	BossService(BossRepository bossRepo, CalculationService calculationService) {
		this.bossRepo = bossRepo;
		this.calculationService = calculationService;
	}
	
	/*
	 * Service method that returns a list of all Bosses in the database
	 * 
	 * @return list of all Bosses
	 */
	public Iterable<Boss> viewBossList() {
		return bossRepo.findAll();
	}
	
	/*
	 * Service method that can return a Boss with the exact name provided
	 * 
	 * @param name String value to find an exact match for in the database
	 * @return Boss object if a value was found in the database
	 * @throws NoneFoundException if no Boss with the exact name is found
	 */
	public Optional<Boss> findByName(String name) {
		Optional<Boss> bossByName = bossRepo.findByName(name);
		
		if (bossByName == null) {
			throw new NoneFoundException("No bosses were found with the name: " + name + " in the database.");
		} else {
			return bossByName;
		}
	}
	
	/*
	 * Service method that can return a collection of Bosses with the provided substring
	 * 
	 * @param name String value of the substring to search for in the database.
	 * @return Iterable<Boss> if Bosses can be found with the substring in their name
	 * @throws NoneFoundException if no Bosses are found containing the substring
	 */
	public Iterable<Boss> findByPartialMatch(String name) {
		Iterable<Boss> bossListByPartialMatch = bossRepo.findByPartialMatch(name);
		
		long count = calculationService.getCount(bossListByPartialMatch);
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses were found similar to the name: " + name + " in the database.");
		} else {
			return bossListByPartialMatch;
		}
	}
	
	/*
	 * Service method that can return a collection of Bosses who are in the provided location
	 * 
	 * @param location String value of the location to search for in the database
	 * @return Iterable<Boss> if Bosses who are in the provided location are in the database
	 * @throws NoMatchingLocationException if no Bosses are found who reside in the location provided
	 */
	public Iterable<Boss> findByLocation(String location) {
		Iterable<Boss> bossListByLocation = bossRepo.findByBossLocation(location);
		
		long count = calculationService.getCount(bossListByLocation);
		
		if (count <= 0) {
			throw new NoMatchingLocationException("No bosses found in the location: " + location + " in the database.");
			
		} else {
			return bossListByLocation;
		}
	}
	/*
	 * Service method that returns a collection of Bosses whose level are equal to the one provided
	 * 
	 * @param level int value of the level to search for in the database
	 * @return Iterable<Boss> if Bosses who are the same level as the one provided exist in the database.
	 * @throws NoneFoundException if no bosses are found who have the same level
	 */
	public Iterable<Boss> findByBossLevel(int level) {
		Iterable<Boss> bossListByLevelEqual = bossRepo.findByBossLevelEquals(level);
		
		long count = calculationService.getCount(bossListByLevelEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with the level: " + level + " in the database.");
		} else {
			return bossListByLevelEqual;
		}
	}
	
	/*
	 * Service method that returns a collection of Bosses whose minimum respawn timer is greater than or equal to the one provided
	 * 
	 * @param respawnTime an int value for the minimum time or greater to find, represented in minutes.
	 * @return Iterable<Boss> if Bosses exist in the database whose minimum respawn time is greater than or equal to the one provided
	 * @throws NoneFoundException if no Bosses are found whose minimum respawn time is at least equal to the one provided
	 */
	public Iterable<Boss> findAllBossMinRespawnGreater(int respawnTime) {
		Iterable<Boss> bossListMinRepsawnGreaterEqual = bossRepo.findAllByBossMinRespawnGreaterThanEqual(respawnTime);
		
		long count = calculationService.getCount(bossListMinRepsawnGreaterEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses found with minimum respawn greater than: " + respawnTime + " in the database.");
		} else {
			return bossListMinRepsawnGreaterEqual;
		}
	}
	
	/*
	 * Service method that returns a collection of Bosses whose maximum respawn timer is greater than or equal to the one provided
	 * 
	 * @param respawnTime an int value for the maximum time for greater to find, represented in minutes.
	 * @return Iterable<Boss> if Bosses exist in the database whose maximum respawn time is greater than or equal to the one provided
	 * @throws NoneFoundException if no Bosses are found whose maximum respawn time is at least equal to the one provided
	 */
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
