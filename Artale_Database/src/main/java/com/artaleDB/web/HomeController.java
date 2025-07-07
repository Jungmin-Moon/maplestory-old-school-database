package com.artaleDB.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.services.DatabaseUpdatesService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	DatabaseUpdatesService databaseUpdatesService;
	
	HomeController(DatabaseUpdatesService databaseUpdatesService) {
		this.databaseUpdatesService = databaseUpdatesService;
	}
	
	
	@GetMapping
	public String home(Model model, @RequestParam (required = false) String mob, @RequestParam (required = false) String boss,
						@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop) {
		
		if (mob != null) {
			return "redirect:/web/mob";
		} 
		
		if (boss != null) {
			return "redirect:/web/boss";
		}
		
		if (equipment != null) {
			return "redirect:/web/equipment";
		}
		
		if (mobdrop != null) {
			return "redirect:/web/drop/mob";
		}
		
		if (bossdrop != null) {
			return "redirect:/web/drop/boss";
		}
		
		var databaseUpdates = databaseUpdatesService.getlast15Updates(LocalDateTime.now());
		
		model.addAttribute("databaseUpdates", databaseUpdates);
		
		return "home.html";
	}
	
}
