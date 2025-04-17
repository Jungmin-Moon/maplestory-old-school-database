package com.artaleDB.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Mob;
import com.artaleDB.entities.NoneFoundException;
import com.artaleDB.services.CalculationService;
import com.artaleDB.services.MobService;

/*
 * REST API that handles endpoints related to only queries made for Mobs
 */
@RestController
@RequestMapping("mobs")
public class MobController {
	
	MobService mobService;
	CalculationService calcService;
	
	MobController(MobService mobService, CalculationService calcService) {
		this.mobService = mobService;
		this.calcService = calcService;
	}
	
	/*
	 * Method that returns every mob and all their details in a JSON format
	 * 
	 * @return the list of all mobs in the database printed in JSON
	 */
	@GetMapping
	public Iterable<Mob> get() {
		return mobService.viewMobList();
	}
	
	/*
	 * Method that returns a Mob that may or may not exist in the database.
	 * 
	 * @param name String that is the name of the mob with a regex restriction based on what characters can be in a mob name
	 * @return Optional<Mob> the mob may or may not be there so in the case of the mob not existing it returns an error message otherwise it returns the mob requested.
	 */
	@GetMapping("/{name:[a-zA-Z &.]*}")
	public Optional<Mob> findByName(@PathVariable String name) {
		return mobService.findByName(name);
	}
	
	/*
	 * Method that returns the list of Mobs that contain the provided substring
	 * 
	 * @param name a substring to check the database for mobs that contain it
	 * @return an exception message or a list of mobs that contain the substring.
	 */
	@GetMapping("/list/{name:[a-zA-Z &.]*}") 
	public Iterable<Mob> findByPartialMatch(@PathVariable String name) {
		return mobService.findByPartialMatch(name);
	}
	
	/*
	 * Method that returns the list of Mobs that are in the locations provided.
	 * 
	 * @param location a String location that can only be [Victoria Island, El Nath, Orbis, Ludibrium, Ellin Forest, Omega Sector, Korean Folk Town, Mu Lung, Herb Town,
	 *                 Zipangu, China, Aqua Road, Magatia, Ariant, Leafre]
	 * @return a list of mobs from the location if either their main location or secondary location is the given string or an exception if empty
	 */
	@GetMapping("/location/{location:[a-zA-Z ]*}")
	public Iterable<Mob> findByLocation(@PathVariable String location) {
		return mobService.findByLocation(location);
	}
	
	/*
	 * Method to return a list of mobs that are equal to a given level
	 * 
	 * @param level an int representing the level of mob users are searching for up to a maximum of 200 
	 * @return a list of mobs that are equal to that level or an exception message if none can be found
	 */
	@GetMapping("/level/{level}")
	public Iterable<Mob> findBylevel(@PathVariable int level) {
		return mobService.findByLevel(level);
	}
	
	/*
	 * Method to return a list of mobs that give equal to the exp amount provided by the user
	 * 
	 * @param exp an int reprsenting the exact exp users are looking for and nothing higher or lower
	 * @return list of mobs that provide the exact amount of exp the user provided or an exception if none fulfill the requirement
	 */
	@GetMapping("/exp/{exp}") 
	public Iterable<Mob> findByEXP(@PathVariable int exp) {
		return mobService.findByMobExp(exp);
	}
	
	/*
	 * Method to return a list of mobs that give equal or greater to the exp amount provided by the user
	 * 
	 * @param exp an int reprsenting the lowest amount of exp a mob gives that a user is looking for
	 * @return a list of mobs that give that much exp or greater but if none can be found returns an exception message instead
	 */
	@GetMapping("/min/exp/{exp}")
	public Iterable<Mob> findByGreaterExp(@PathVariable int exp) {
		return mobService.findByMobExpGreater(exp);
	}
	
	/*
	 * Method to return a list of mobs that give equal or greater minimum meso than the number provided by the user
	 * 
	 * @param meso an int representing the minimum amount of meso a mob drop
	 * @return a list of mobs that drop the minimum amount of meso or higher provided or returns an exception message if none can be found.
	 */
	@GetMapping("/min/meso/{meso}") 
	public Iterable<Mob> findMinMesoHigher(@PathVariable int meso) {
		return mobService.findMinMesoGreater(meso);
	}
	
	/*
	 * Method to return a list of mobs that give equal or greater maximum meso than the number provided by the user.
	 * 
	 * @param meso an int representing the maximum amount of meso a mob can drop.
	 * @return a list of mobs that give equal or greater than the meso provided by the user or an exception message if none can be found.
	 */
	@GetMapping("/max/meso/{meso}")
	public Iterable<Mob> findMaxMesoHigher(@PathVariable int meso) {
		return mobService.findMaxMesoGreater(meso);
	}
}
