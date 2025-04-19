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
 * REST API that handles endpoints related to only queries made for Mobs results are returned in JSON
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
	 * @return a collection of all mobs in the database
	 */
	@GetMapping
	public Iterable<Mob> get() {
		return mobService.viewMobList();
	}
	
	/*
	 * Method that returns a Mob that may or may not exist in the database.
	 * 
	 * @param name String that is the name of the mob with a regex restriction based on what characters can be in a mob name
	 * @return Optional<Mob> the mob if one with the exact name exists in the database
	 * @throws NoneFoundException if no mobs is found with the exact name in the database
	 */
	@GetMapping("/{name:[a-zA-Z &.]*}")
	public Optional<Mob> findByName(@PathVariable String name) {
		return mobService.findByName(name);
	}
	
	/*
	 * Method that returns a collection of Mobs that contain the provided substring
	 * 
	 * @param name a substring to check the database for mobs that contain it
	 * @return Iterable<Mob> a collection of mobs that contain the substring.
	 * @throws NoneFoundException if no mobs with that contain the substring are in the database
	 */
	@GetMapping("/list/{name:[a-zA-Z &.]*}") 
	public Iterable<Mob> findByPartialMatch(@PathVariable String name) {
		return mobService.findByPartialMatch(name);
	}
	
	/*
	 * Method that returns a collection of Mobs that are in the location provided.
	 * 
	 * @param location a String location that can only be [Victoria Island, El Nath, Orbis, Ludibrium, Ellin Forest, Omega Sector, Korean Folk Town, Mu Lung, Herb Town,
	 *                 Zipangu, China, Aqua Road, Magatia, Ariant, Leafre, Deep Sea]
	 * @return Iterable<Mob> a collection of mobs from the location if either their main location or secondary location is the given string
	 * @throws NoMatchingLocationException if no mobs have their location one or location two equal to the one provided
	 */
	@GetMapping("/location/{location:[a-zA-Z ]*}")
	public Iterable<Mob> findByLocation(@PathVariable String location) {
		return mobService.findByLocation(location);
	}
	
	/*
	 * Method to return a list of mobs that are equal to a given level
	 * 
	 * @param level an int representing the level of mob users are searching for up to a maximum of 200 
	 * @return Iterable<Mob> a collection of mobs whose level is equal to the parameter
	 * @throws NoneFoundException if no mobs exist in the database whose level is equal to the one provided
	 */
	@GetMapping("/level/{level}")
	public Iterable<Mob> findBylevel(@PathVariable int level) {
		return mobService.findByLevel(level);
	}
	
	/*
	 * Method to return a list of mobs that give equal to the exp amount provided by the user
	 * 
	 * @param exp an int reprsenting the exact exp users are looking for and nothing higher or lower
	 * @return Iterable<Mob> a collection of mobs that provide the exact amount of exp the user provided
	 * @throws NoneFoundException if no mobs give the exp equal to the provided value
	 */
	@GetMapping("/exp/{exp}") 
	public Iterable<Mob> findByEXP(@PathVariable int exp) {
		return mobService.findByMobExp(exp);
	}
	
	/*
	 * Method to return a list of mobs that give equal or greater to the exp amount provided by the user
	 * 
	 * @param exp an int reprsenting the lowest amount of exp a mob gives that a user is looking for
	 * @return Iterable<Mob> a collection of mobs that give that much exp or greater
	 * @throws NoneFoundException if no mobs give exp greater than or equal to provided value
	 */
	@GetMapping("/min/exp/{exp}")
	public Iterable<Mob> findByGreaterExp(@PathVariable int exp) {
		return mobService.findByMobExpGreater(exp);
	}
	
	/*
	 * Method to return a list of mobs that give equal or greater minimum meso than the number provided by the user
	 * 
	 * @param meso an int representing the minimum amount of meso a mob drop
	 * @return Iterable<Mob> a collection of mobs that drop the minimum amount of meso or higher given
	 * @throws NoneFoundException if no mobs whose minimum meso drop is greater than or equal to the provided value
	 */
	@GetMapping("/min/meso/{meso}") 
	public Iterable<Mob> findMinMesoHigher(@PathVariable int meso) {
		return mobService.findMinMesoGreater(meso);
	}
	
	/*
	 * Method to return a list of mobs that give equal or greater maximum meso than the number provided by the user.
	 * 
	 * @param meso an int representing the maximum amount of meso a mob can drop.
	 * @return a list of mobs that give equal or greater than the meso provided
	 */
	@GetMapping("/max/meso/{meso}")
	public Iterable<Mob> findMaxMesoHigher(@PathVariable int meso) {
		return mobService.findMaxMesoGreater(meso);
	}
}
