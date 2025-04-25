package com.artaleDB.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.entities.Boss;
import com.artaleDB.services.BossService;
/*
 * RestController that hosts the endpoints related to bosses in Artale. Data is returned formatted in JSON
 */
@RestController
@RequestMapping("boss")
public class BossController {
	
	BossService bossService;
	
	BossController(BossService bossService) {
		this.bossService = bossService;
	}
	
	/*
	 * Method that returns the list of all bosses in the database
	 * 
	 * @return Iterable<Boss> list of all bosses in the database
	 */
	@GetMapping
	public Iterable<Boss> getAll() {
		return bossService.viewBossList();
	}
	
	/*
	 * Method that returns the Boss with the exact same name as the one given
	 * 
	 * @param name String that is the name of the boss being searched for
	 * @return Optional<Boss> a Boss object with details if it exists in the database
	 * @throws NoneFoundException if no bosses exist in the database with the same name as the one given
	 */
	@GetMapping("/{name:[a-zA-Z &.]*}")
	public Optional<Boss> findByName(@PathVariable String name) {
		return bossService.findByName(name);
	}
	
	/*
	 * Method that returns a collection of bosses whose name contains the given substring
	 * 
	 * @param name the substring to search for
	 * @return Iterable<Boss> a collection of Bosses whose name contains the substring
	 * @throws NoneFoundException if no bosses are found that contain the substring in the database
	 */
	@GetMapping("/list/{name:[a-zA-Z &.]*}")
	public Iterable<Boss> findByPartialMatch(@PathVariable String name) {
		return bossService.findByPartialMatch(name);
	}
	
	/*
	 * Method that searches for bosses based on location given
	 * 
	 * @param location String location that the user wants to search in
	 * @return Iterable<Boss> a collection of Bosses who are located in the given location
	 * @throws NoneFoundException if no bosses are found that are in the location
	 */
	@GetMapping("/location/{location:[a-zA-Z ]*}")
	public Iterable<Boss> findByLocation(@PathVariable String location) {
		return bossService.findByLocation(location);
	}
	
	/*
	 * Method that searches for bosses whose level is equal to the one given
	 * 
	 * @param level int value representing the level to search for
	 * @return Iterable<Boss> a collection of bosses whose level is equal to the one given
	 * @throws NoneFoundException if no bosses are found whose level is equal to the one provided
	 */
	@GetMapping("/level/{level}") 
	public Iterable<Boss> findByLevel(@PathVariable int level) {
		return bossService.findByBossLevel(level);
	}
	
	
	/*
	 * Method that searches for bosses based on their minimum respawn timer. Respawn timer is represented in minutes; Two hours is 120 
	 * 
	 * @param timer int value representing the minimum respawn timer for a boss that a user wants to search for
	 * @return Iterable<Boss> a collection of bosses who minimum respawn time is greater than or equal to the one provided
	 * @throws NoneFoundException if no bosses are found whose minimum respawn time is greater than or equal to the one given
	 */
	@GetMapping("/respawn/min/{timer}")
	public Iterable<Boss> getAllMinRespawnGreater(@PathVariable int timer) {
		return bossService.findAllBossMinRespawnGreater(timer);
	}
	
	/*
	 * Method that searches for bosses based on their maximum respawn timer. Respawn timer is represented in minutes; Two hours is 120
	 * 
	 * @param timer int value representing the maximum respawn timer for a boss that a user wants to search for
	 * @return Iterable<Boss> a collection of bosses who maximum respawn time is greater than or equal to the one provided
	 * @throws NoneFoundException if no bosses are found whose maximum respawn time is greater than or equal to the one given
	 */
	@GetMapping("/respawn/max/{timer}")
	public Iterable<Boss> getAllMaxRespawnGreater(@PathVariable int timer) {
		return bossService.findAllBossMaxRespawnGreater(timer);
	}
}
