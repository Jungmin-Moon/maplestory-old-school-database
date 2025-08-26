package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
							@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop,
							@RequestParam(required = false) String bossName, @RequestParam(required = false) Integer bossLevel, @RequestParam(required = false) Integer bossMinRespawn, 
							@RequestParam(required = false) Integer bossMaxRespawn, @RequestParam(required = false) String bossLocation) {
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
		
		//UserSearchQueryBoss uSearch = new UserSearchQueryBoss(bossName, bossLevel, bossMinRespawn, bossMaxRespawn, bossLocation);
		
		//System.out.println(bossLevel);
		
		if (bossName == null && bossLevel == null && bossMinRespawn == null && bossMaxRespawn == null && bossLocation == null) {
			var allBoss = bossService.findAllBossWeb();
			model.addAttribute("allBoss", allBoss);
			//model.addAttribute("allBoss", allBoss);
		} else {
			UserSearchQueryBoss uSearch = new UserSearchQueryBoss(bossName, bossLevel, bossMinRespawn, bossMaxRespawn, bossLocation);
			var userBossSearch = bossService.findByUserQueryBossWeb(uSearch.getBossName(), uSearch.getBossLevel(), uSearch.getBossMinRespawn(), 
					uSearch.getBossMaxRespawn(), uSearch.getBossLocation());

			model.addAttribute("allBoss", userBossSearch);
		}
		
		
		return "bosses.html";
	}
}
