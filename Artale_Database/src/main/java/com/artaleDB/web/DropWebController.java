package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artaleDB.services.DropService;

@Controller
@RequestMapping("/web/drop")
public class DropWebController {

	DropService dropService;
	
	DropWebController(DropService dropService) {
		this.dropService = dropService;
	}
	
	
	@GetMapping("/mob")
	public String mobDropHome(Model model) {
		
		var allMobDrops = dropService.findAllMobDropsWeb();
		
		model.addAttribute("mobDropsAll", allMobDrops);
		
		return "mob_drops";
	}
	
	
	@GetMapping("/boss") 
	public String bossDropHome(Model model) {
		
		var allBossDrops = dropService.findAllBossDropsWeb();
		
		model.addAttribute("bossDropsAll", allBossDrops);
		
		return "boss_drops";
	}
	
	
}
