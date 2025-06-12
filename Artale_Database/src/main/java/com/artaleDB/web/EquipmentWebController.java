package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.services.EquipmentService;

@Controller
@RequestMapping("/web/equipment")
public class EquipmentWebController {
	
	EquipmentService equipmentService;
	
	EquipmentWebController(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}
	
	
	@GetMapping
	public String equipment(Model model, @RequestParam (required = false) String home, @RequestParam (required = false) String mob,
							@RequestParam (required = false) String boss, @RequestParam (required = false) String drop) {
		
		if (home != null) {
			return "redirect:/home";
		}
		
		if (mob != null) {
			return "redirect:/web/mob";
		}
		
		if (boss != null) {
			return "redirect:/web/boss";
		}
		
		if (drop != null) {
			return "redirect:/web/drop";
		}
		
		var allEquipment = equipmentService.findAllWeb();
		
		model.addAttribute("allEquipment", allEquipment);
		
		return "equipment";
	}
}
