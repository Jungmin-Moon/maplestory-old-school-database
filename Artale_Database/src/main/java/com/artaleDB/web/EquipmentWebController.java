package com.artaleDB.web;

import java.util.List;

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
							@RequestParam (required = false) String boss, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop,
							@RequestParam (required = false) List<String> equipmentType, @RequestParam(required = false) int minimumLevel, @RequestParam(required = false) int warrior,
							@RequestParam(required = false) int magician, @RequestParam(required = false) int thief, @RequestParam(required = false) int archer, 
							@RequestParam(required = false) int pirate, @RequestParam(required = false) int beginner, @RequestParam(required = false) int common) {
		
		if (home != null) {
			return "redirect:/home";
		}
		
		if (mob != null) {
			return "redirect:/web/mob";
		}
		
		if (boss != null) {
			return "redirect:/web/boss";
		}
		
		if (mobdrop != null) {
			return "redirect:/web/drop/mob";
		}
		
		if (bossdrop != null) {
			return "redirect:/web/drop/boss";
		}
		
		var allEquipment = equipmentService.findAllWeb();
		
		model.addAttribute("allEquipment", allEquipment);
		
		return "equipment";
	}
}
