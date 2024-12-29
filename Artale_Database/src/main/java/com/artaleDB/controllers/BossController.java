package com.artaleDB.controllers;

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

@RestController
@RequestMapping("/api/v1/boss")
public class BossController {
	
	BossService bossService;
	
	
	BossController(BossService bossService) {
		this.bossService = bossService;
	}
	
	
	@GetMapping("/all")
	public List<Boss> findAll() {
		return bossService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable long id) {
		
		Optional<Boss> bossById = bossService.returnById(id);
		
		if (bossById.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(bossById);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no boss.");
		}
	}
	
	@GetMapping("/name/{name:[a-zA-Z &+-.]*}")
	public ResponseEntity<Object> findByName(@PathVariable String name) {
		
		List<Boss> bossByName = bossService.returnBossByName(name);
		
		if (bossByName.size() > 1) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body(bossByName);
		} else if (bossByName.size() == 1) {
			return ResponseEntity.status(HttpStatus.OK)
								.body(bossByName);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no boss.");
		}
		
	}
	
	@GetMapping("/location/{location:[a-zA-Z &+-.]*}")
	public ResponseEntity<Object> findByLocation(@PathVariable String location) {
		
		List<Boss> bossByLocation = bossService.returnBossByLocation(location);
		
		if (bossByLocation.size() > 1) {
			return ResponseEntity.status(HttpStatus.MULTIPLE_CHOICES)
								.body(bossByLocation);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no boss.");
		}
		
	}
	
	@GetMapping("/level/asc") 
	public ResponseEntity<Object> orderByLevelAsc() {
		List<Boss> levelOrderAsc = bossService.returnBossByLevelAsc();
		
		if (levelOrderAsc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no boss.");
		} else {
			return ResponseEntity.status(HttpStatus.OK)
								.body(levelOrderAsc);
		}
	}
	
	@GetMapping("/level/desc")
	public ResponseEntity<Object> orderBylevelDesc() {
		List<Boss> levelOrderDesc = bossService.returnBossByLevelDesc();
		
		if (levelOrderDesc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no boss.");
		} else {
			return ResponseEntity.status(HttpStatus.OK)
								.body(levelOrderDesc);
		}
	}
	
	
	@GetMapping("/hp/asc")
	public ResponseEntity<Object> orderByHPAsc() {
		List<Boss> hpOrderAsc = bossService.returnBossByHPAsc();
		
		if (hpOrderAsc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no boss,");
		} else {
			return ResponseEntity.status(HttpStatus.OK)
								.body(hpOrderAsc);
		}
	}
	
	@GetMapping("/hp/desc")
	public ResponseEntity<Object> orderByHPDesc() {
		List<Boss> hpOrderDesc = bossService.returnBossByHPDesc();
		
		if (hpOrderDesc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no boss.");
		} else {
			return ResponseEntity.status(HttpStatus.OK)
								.body(hpOrderDesc);
		}
	}
	
	@GetMapping("/max-respawn/asc")
	public ResponseEntity<Object> orderByMaxRespawnAsc() {
		
		List<Boss> maxRespawnAsc = bossService.returnBossByMaxRespawnAsc();
		
		if (maxRespawnAsc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no data.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("Time", "Minutes")
								.body(maxRespawnAsc);
		}
	}
	
	@GetMapping("/max-respawn/desc")
	public ResponseEntity<Object> orderByMaxRespawnDesc() {
		List<Boss> maxRespawnDesc = bossService.returnBossByMaxRespawnDesc();
		
		if (maxRespawnDesc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no data.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("Time", "Minutes")
								.body(maxRespawnDesc);
		}
	}
	
	@GetMapping("/min-respawn/asc")
	public ResponseEntity<Object> orderByMinRespawnAsc() {
		List<Boss> minRespawnAsc = bossService.returnBossByMinRespawnAsc();
		
		if (minRespawnAsc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no data.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("Time", "Minutes")
								.body(minRespawnAsc);
		}
	}
	
	@GetMapping("/min-respawn/desc")
	public ResponseEntity<Object> orderByMinRespawnDesc() {
		List<Boss> minRespawnDesc = bossService.returnBossByMinRespawnDesc();
		
		if (minRespawnDesc.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no data.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("Time", "Minutes")
								.body(minRespawnDesc);
		}
	}
	
	@GetMapping("/max-respawn/{time}")
	public ResponseEntity<Object> orderByMaxRespawnLimit(@PathVariable int time) {
		List<Boss> maxRespawnLimit = bossService.returnBossByMaxRespawnLimit(time);
		
		if (maxRespawnLimit.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no data.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("Time", "Minutes")
								.body(maxRespawnLimit);
		}
	}
	
	@GetMapping("/min-respawn/{time}")
	public ResponseEntity<Object> orderByMinRespawnLimit(@PathVariable int time) {
		List<Boss> minRespawnLimit = bossService.returnBossByMinRespawnLimit(time);
		
		if (minRespawnLimit.size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("There is no data.");
		} else {
			return ResponseEntity.status(HttpStatus.OK).header("Time", "Minutes")
								.body(minRespawnLimit);
		}
	}
}
