package com.artaleDB.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.artaleDB.services.EquipmentService;

@Controller
@RequestMapping("/web/equipment")
public class EquipmentWebController {
	
	EquipmentService equipmentService;
	
	EquipmentWebController(EquipmentService equipmentService) {
		this.equipmentService = equipmentService;
	}
	
	
	@GetMapping
	public String equipment(Model model) {
		
		var allEquipment = equipmentService.getAllEquipment();
		
		model.addAttribute("allEquipment", allEquipment);
		
		return "equipment";
	}
}
