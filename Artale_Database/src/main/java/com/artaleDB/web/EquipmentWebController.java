package com.artaleDB.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.entities.Equipment;
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
							@RequestParam (required = false) List<String> equipmentType, @RequestParam(required = false) Integer minimumLevel, @RequestParam(required = false) Integer warrior,
							@RequestParam(required = false) Integer magician, @RequestParam(required = false) Integer thief, @RequestParam(required = false) Integer archer, 
							@RequestParam(required = false) Integer pirate, @RequestParam(required = false) Integer beginner, @RequestParam(required = false) Integer common,
							@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, @RequestParam("equipmentType") Optional<List<String>> equipType) {
		
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
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(30);
		List<String> eType = equipType.orElse(equipmentType);
		
		Page<Equipment> equipPage;
		
		if (equipmentType == null ||minimumLevel == null || warrior == null || magician == null || thief == null || archer == null || pirate == null || beginner == null || common == null) {
			minimumLevel = warrior = magician = thief = archer = pirate = beginner = common = 0;
			equipmentType = new ArrayList<>();
			
			equipPage = equipmentService.findAllWeb(PageRequest.of(currentPage - 1, pageSize));
		} else {
			equipPage = equipmentService.findAllWeb(PageRequest.of(currentPage - 1, pageSize));
			
			/*
			StringBuilder s = new StringBuilder();
			
			for (String str: equipmentType) {
				s.append("equipmentType=");
				s.append(str);
				s.append("&");
			}
			
			String equipTypeQuery = s.toString(); */
			
			System.out.println(equipmentType.toString());
		}
		
		int totalPages = equipPage.getTotalPages();
		model.addAttribute("equipPage", equipPage);
		model.addAttribute("equipmentTypeQuery", eType);
		
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
												.boxed()
												.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		//model.addAttribute("equipmentTypeQuery", equipmentType);
		/*
		System.out.println("Chosen equipment are: ");
		for(String s: equipmentType) {
			System.out.println(s);
		} */
		
		return "equipment";
	}
}
