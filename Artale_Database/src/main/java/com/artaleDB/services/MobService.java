package com.artaleDB.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Mob;
import com.artaleDB.entities.NoMatchingLocationException;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.repositories.MobRepository;

/*
 * Service class that handles getting all information about Mobs from the database and passes it to the MobController in JSON
 */
@Service
public class MobService {
	
	MobRepository mobRepo;
	CalculationService calculationService;
	
	MobService(MobRepository mobRepo, CalculationService calculationService) {
		this.mobRepo = mobRepo;
		this.calculationService = calculationService;
	}
	
	/*
	 * Service method that just returns all mobs in the database
	 * 
	 * @return list of mobs in the database
	 */
	public Iterable<Mob> viewMobList() {
		return mobRepo.findAll();
	}
	
	/*
	 * Service method that searches the repository for a mob with the exact same name as provided.
	 * 
	 * @param name String value of the exact name to search for in the database
	 * @return Optional<Mob> if a mob exists with the exact name it returns the mob
	 * @throws NoneFoundException if no mob can be found with the exact name in the database
	 */
	public Optional<Mob> findByName(String name) {
		Optional<Mob> potentialMobExist = mobRepo.findByName(name);
		
		if (potentialMobExist == null) {
			throw new NoneFoundException("No mobs found with name: " + name + " in the database.");
		} else {
			return potentialMobExist;
		}
	}
	
	/*
	 * Service method that searches the repository for mobs that contains the provided substring
	 * 
	 * @param name a substring to search for provided by the controller
	 * @return Iterable<Mob> a collection of mobs that contain that substring.
	 * @throws NoneFoundException if no mobs are found that contain the provided substring.
	 */
	public Iterable<Mob> findByPartialMatch(String substring) {
		Iterable<Mob> mobListPartialNameMatch = mobRepo.findByPartialMatch(substring);
		
		long count = calculationService.getCount(mobListPartialNameMatch);
		
		if (count > 0) {
			return mobListPartialNameMatch;
		} else {
			throw new NoneFoundException("No mobs found that match: " + substring + " in the database.");
		}
	}
	
	/*
	 * Service method that searches the repository for mobs that are in the location provided
	 * 
	 * @param location a string to search for provided by the controller
	 * @return Iterable<Mob> a collection of mobs whose location one or location two matches the provided location String
	 * @throws NoMatchingLocationException if no mobs are found in the location provided.
	 */
	public Iterable<Mob> findByLocation(String location) {
		Iterable<Mob> mobListByLocations = mobRepo.findByMobLocationAndMobLocationTwo(location, location);
		
		long count = calculationService.getCount(mobListByLocations);
		
		if (count <= 0) {
			throw new NoMatchingLocationException("No mobs found in the location: " + location + " in the database.");
		} else {
			return mobListByLocations;
		}
	}
	
	/*
	 * Service method that searches the repository for mobs that are equal to the level provided
	 * 
	 * @param level a int to search for provided by the controller
	 * @return Iterable<Mob> a collection of mobs whose level is exactly equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found whose level is exactly equal to the one provided.
	 */
	public Iterable<Mob> findByLevel(int level) {
		Iterable<Mob> mobListByLevel = mobRepo.findByMobLevelEquals(level);
		
		long count = calculationService.getCount(mobListByLevel);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found with the level: " + level + " in the database,");
		} else {
			return mobListByLevel;
		}
	}
	
	/*
	 * Service method that searches the repository for mobs that give exp greater than or equal to the one provided
	 * 
	 * @param exp an int to search for provided by the controller
	 * @return Iterable<Mob> a collection of mobs whose exp is greater than or equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found whose exp is equal or greater than the one provided
	 */
	public Iterable<Mob> findByMobExpGreater(int exp) {
		Iterable<Mob> mobListExpGreaterThanEqual = mobRepo.findAllByMobEXPGreaterThanEqual(exp);
		
		long count = calculationService.getCount(mobListExpGreaterThanEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs that give exp greater than " + exp + " found in the database.");
		} else {
			return mobListExpGreaterThanEqual;
		}
	}
	
	/*
	 * Service method that searches the repository for mobs who give exactly the same amount of exp provided
	 * 
	 * @param exp an int representing the exact exp provided by the controller
	 * @return Iterable<Mob> a collection of mobs whose exp given is exactly equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found that give exactly the exp provided
	 */
	public Iterable<Mob> findByMobExp(int exp) {
		Iterable<Mob> mobListExpEqual = mobRepo.findAllByMobEXP(exp);
		
		long count = calculationService.getCount(mobListExpEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs that give exp: " + exp + " found in the database.");
		} else {
			return mobListExpEqual;
		}
	}
	
	/*
	 * Service method that searches the repository to find mobs whose minimum meso drop is greater than or equal to the one provided
	 * 
	 * @return Iterable<Mob> a collection of mobs whose minimum meso dropped is greater than or equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found that drop greater than or equal to the minimum meso provided
	 */
	public Iterable<Mob> findMinMesoGreater(int minMeso) {
		Iterable<Mob> mobListMinMesoGreaterEqual = mobRepo.findAllByMobMinMesoGreaterThanEqual(minMeso);
		
		long count = calculationService.getCount(mobListMinMesoGreaterEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found that drop higher minimum meso than " + minMeso + " found in the database.");
		} else {
			return mobListMinMesoGreaterEqual;
		}
	}
	
	/*
	 * Service method that searches the repository to find mobs whose maximum meso drop is greater than or equal to the one provided
	 * 
	 * @return Iterable<Mob> a collection of mobs whose maximum meso dropped is greater than or equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found that drop greater than or equal to the maximum meso provided
	 */
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
