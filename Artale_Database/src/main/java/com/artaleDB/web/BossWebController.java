package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.dto.UserSearchQueryBoss;
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
							@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop) {
		if (home != null) {
			return "redirect:/home";
		}
		
		if (mob != null) {
			return "redirect:/web/mob";
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
		
		var allBoss = bossService.findAllBossWeb();
		
		model.addAttribute("allBoss", allBoss);
		
		return "bosses.html";
	}
	
	@PostMapping
	public String afterSearchBoss(Model model, @RequestParam (required = false) String home, @RequestParam (required = false) String mob,
									@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop, UserSearchQueryBoss uBossSearch) {
		if (home != null) {
			return "redirect:/home";
		}
		
		if (mob != null) {
			return "redirect:/web/mob";
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
		
		var userBossSearch = bossService.findByUserQueryBossWeb(uBossSearch.getBossName(), uBossSearch.getBossLevel(), uBossSearch.getBossMinRespawn(), 
																uBossSearch.getBossMaxRespawn(), uBossSearch.getBossLocation());
		
		model.addAttribute("allBoss", userBossSearch);
		
		
		return "bosses.html";
	}
}
