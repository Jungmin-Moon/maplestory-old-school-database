package com.artaleDB.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.kafka.KafkaSender;
import com.artaleDB.services.DatabaseUpdatesService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	DatabaseUpdatesService databaseUpdatesService;
	KafkaSender kafkaSender;
	
	HomeController(DatabaseUpdatesService databaseUpdatesService, KafkaSender kafkaSender) {
		this.databaseUpdatesService = databaseUpdatesService;
		this.kafkaSender = kafkaSender;
	}
	
	
	@GetMapping
	public String home(Model model, @RequestParam (required = false) String mob, @RequestParam (required = false) String boss,
						@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop) {
		
		if (mob != null) {
			kafkaSender.sendMessage("Link-Click-Events", "Key-1", "Mob search was clicked.");
			return "redirect:/web/mob";
		} 
		
		if (boss != null) {
			kafkaSender.sendMessage("Link-Click-Events", "Key-1", "Boss search was clicked.");
			return "redirect:/web/boss";
		}
		
		if (equipment != null) {
			kafkaSender.sendMessage("Link-Click-Events", "Key-1", "Equipment search was clicked.");
			return "redirect:/web/equipment";
		}
		
		if (mobdrop != null) {
			kafkaSender.sendMessage("Link-Click-Events", "Key-1", "Mob drop search was clicked.");
			return "redirect:/web/drop/mob";
		}
		
		if (bossdrop != null) {
			kafkaSender.sendMessage("Link-Click-Events", "Key-1", "Boss drop search was clicked.");
			return "redirect:/web/drop/boss";
		}
		
		var databaseUpdates = databaseUpdatesService.getlast15Updates(LocalDateTime.now());
		
		var dateTimes = databaseUpdatesService.convertTime(databaseUpdates);
		
		var convertedUpdates = databaseUpdatesService.makeReadable(databaseUpdates, dateTimes);
		
		model.addAttribute("databaseUpdates", convertedUpdates);
		//model.addAttribute("timeConverted", dateTimes);
		
		return "home.html";
	}
	
}
