package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.services.BossService;

@Controller
@RequestMapping("/web/boss")
public class BossWebController {
	
	BossService bossService;
	
	BossWebController(BossService bossService) {
		this.bossService = bossService;	
	}
	
	
	@GetMapping
	public String bossHome(Model model, @RequestParam (required = false) String home, @RequestParam (required = false) String mob,
							@RequestParam (required = false) String equipment, @RequestParam (required = false) String drop) {
		if (home != null) {
			return "";
		}
		
		if (mob != null) {
			return "";
		}
		
		if (equipment != null) {
			return "";
		}
		
		if (drop != null) {
			return "";
		}
		
		var allBoss = bossService.findAllBossWeb();
		
		model.addAttribute("allBoss", allBoss);
		
		return "bosses.html";
	}
}
