package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artaleDB.services.MobService;

@Controller
@RequestMapping("/web/mob")
public class MobWebController {

	MobService mobService;
	
	MobWebController(MobService mobService) {
		this.mobService = mobService;
	}
	
	
	@GetMapping
	public String mobHome(Model model) {
		
		var mobsAll = mobService.viewMobList();
		
		model.addAttribute("allMobs", mobsAll);
		
		return "mobs";
	}
	
}
