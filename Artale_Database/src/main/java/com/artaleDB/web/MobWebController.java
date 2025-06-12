package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.services.MobService;

@Controller
@RequestMapping("/web/mob")
public class MobWebController {

	MobService mobService;
	
	MobWebController(MobService mobService) {
		this.mobService = mobService;
	}
	
	
	@GetMapping
	public String mobHome(Model model, @RequestParam (required = false) String home, @RequestParam (required = false) String boss, 
							@RequestParam (required = false) String equipment, @RequestParam (required = false) String drop) {
		if (home != null) {
			return "redirect:/home";
		}
		
		if (boss != null) {
			return "redirect:/web/boss";
		}
		
		if (equipment != null) {
			return "redirect:/web/equipment";
		}
		
		if (drop != null) {
			return "redirect:/web/drop";
		}
		
		
		var mobsAll = mobService.findAllWeb();
		
		model.addAttribute("allMobs", mobsAll);
		
		return "mobs.html";
	}
}
