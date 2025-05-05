package com.artaleDB.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artaleDB.services.DatabaseUpdatesService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	DatabaseUpdatesService databaseUpdatesService;
	
	HomeController(DatabaseUpdatesService databaseUpdatesService) {
		this.databaseUpdatesService = databaseUpdatesService;
	}
	
	
	@GetMapping
	public String home(Model model) {
		
		var databaseUpdates = databaseUpdatesService.getlastSevenUpdates(LocalDateTime.now());
		
		model.addAttribute("databaseUpdates", databaseUpdates);
		
		return "home.html";
	}
	
	
	@PostMapping
	public String mobs() {
		return "mobs.html";
	}
	
	
	@PostMapping
	public String bosses() {
		return "bosses.html";
	}
	
	@PostMapping
	public String equipment() {
		return "equipment.html";
	}
	
	@PostMapping
	public String drops() {
		return "drops.html";
	}
}
