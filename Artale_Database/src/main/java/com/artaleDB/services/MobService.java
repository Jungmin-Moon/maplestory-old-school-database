package com.artaleDB.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	ListChecker listChecker;
	
	MobService(MobRepository mobRepo, CalculationService calculationService, ListChecker listChecker) {
		this.mobRepo = mobRepo;
		this.calculationService = calculationService;
		this.listChecker = listChecker;
	}
	
	/*
	 * Service method that just returns all mobs in the database
	 * 
	 * @return list of mobs in the database
	 */
	public List<Mob> viewMobList() {
		var mobAll = mobRepo.findAll();
		
		long count = calculationService.getCount(mobAll);
		
		if (count <= 0) {
			throw new NoneFoundException("The database is currently empty.");
		} else {
			return mobAll;
		}
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
	 * @return List<Mob> a collection of mobs that contain that substring.
	 * @throws NoneFoundException if no mobs are found that contain the provided substring.
	 */
	public List<Mob> findByPartialMatch(String substring) {
		List<Mob> mobListPartialNameMatch = mobRepo.findByPartialMatch(substring);
		
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
	 * @return List<Mob> a collection of mobs whose location one or location two matches the provided location String
	 * @throws NoMatchingLocationException if no mobs are found in the location provided.
	 */
	public List<Mob> findByLocation(String location) {
		List<Mob> mobListByLocations = mobRepo.findByMobLocationOrMobLocationTwo(location, location);
		
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
	 * @return List<Mob> a collection of mobs whose level is exactly equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found whose level is exactly equal to the one provided.
	 */
	public List<Mob> findByLevel(int level) {
		List<Mob> mobListByLevel = mobRepo.findByMobLevelEquals(level);
		
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
	 * @return List<Mob> a collection of mobs whose exp is greater than or equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found whose exp is equal or greater than the one provided
	 */
	public List<Mob> findByMobExpGreater(int exp) {
		List<Mob> mobListExpGreaterThanEqual = mobRepo.findAllByMobEXPGreaterThanEqual(exp);
		
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
	 * @return List<Mob> a collection of mobs whose exp given is exactly equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found that give exactly the exp provided
	 */
	public List<Mob> findByMobExp(int exp) {
		List<Mob> mobListExpEqual = mobRepo.findAllByMobEXP(exp);
		
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
	 * @return List<Mob> a collection of mobs whose minimum meso dropped is greater than or equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found that drop greater than or equal to the minimum meso provided
	 */
	public List<Mob> findMinMesoGreater(int minMeso) {
		List<Mob> mobListMinMesoGreaterEqual = mobRepo.findAllByMobMinMesoGreaterThanEqual(minMeso);
		
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
	 * @return List<Mob> a collection of mobs whose maximum meso dropped is greater than or equal to the one provided by the controller
	 * @throws NoneFoundException if no mobs are found that drop greater than or equal to the maximum meso provided
	 */
	public List<Mob> findMaxMesoGreater(int maxMeso) {
		List<Mob> mobListMaxMesoGreaterEqual = mobRepo.findAllByMobMaxMesoGreaterThanEqual(maxMeso);
		
		long count = calculationService.getCount(mobListMaxMesoGreaterEqual);
		
		if (count <= 0) {
			throw new NoneFoundException("No mobs found that drop higher maximum meso than " + maxMeso + " found in the database.");
		} else {
			return mobListMaxMesoGreaterEqual;
		}
	}
	
	
	public Page<Mob> findAllWeb(Pageable pageable) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int start = currentPage * pageSize;
		
		List<Mob> allMobsPage;
		var allMobs = mobRepo.findAllByOrderByMobLevelAsc();
		
		allMobsPage = listChecker.checkIfEmptyElseCreateSubList(allMobs, start, pageSize, allMobs.size());
		
		Page<Mob> mobPage = new PageImpl<Mob>(allMobsPage, PageRequest.of(currentPage, pageSize), allMobs.size());
		
		return mobPage;
	}
	
	public Page<Mob> findByUserQueryMobWeb(String mobName, int mobLevel, int mobEXP, String mobLocationOne, String mobLocationTwo, Pageable pageable) {
		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int start = currentPage * pageSize;
		
		List<Mob> mobQueryPage;
		var mobQueryResult = mobRepo.findUsingUserQuery(mobName, mobLevel, mobEXP, mobLocationOne, mobLocationTwo);
		
		mobQueryPage = listChecker.checkIfEmptyElseCreateSubList(mobQueryResult, start, pageSize, mobQueryResult.size());
		
		return new PageImpl<Mob>(mobQueryPage, PageRequest.of(currentPage, pageSize), mobQueryResult.size());
	}
}
