package com.artaleDB.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

import com.artaleDB.dto.UserSearchQueryEquipment;
import com.artaleDB.entities.Equipment;
import com.artaleDB.kafka.KafkaSender;
import com.artaleDB.services.EquipmentService;

@Controller
@RequestMapping("/web/equipment")
public class EquipmentWebController {
	
	EquipmentService equipmentService;
	KafkaSender kafkaSender;
	
	EquipmentWebController(EquipmentService equipmentService, KafkaSender kafkaSender) {
		this.equipmentService = equipmentService;
		this.kafkaSender = kafkaSender;
	}
	
	@GetMapping
	public String equipment(Model model, @RequestParam (required = false) String home, @RequestParam (required = false) String mob,
							@RequestParam (required = false) String boss, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop,
							@RequestParam(required = false) String equipmentName, @RequestParam (required = false) List<String> equipmentType, @RequestParam(required = false) Integer minimumLevel, 
							@RequestParam(required = false) Integer warrior, @RequestParam(required = false) Integer magician, @RequestParam(required = false) Integer thief, 
							@RequestParam(required = false) Integer archer, @RequestParam(required = false) Integer pirate, @RequestParam(required = false) Integer beginner, 
							@RequestParam(required = false) Integer common, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm");
		
		
		if (home != null) {
			kafkaSender.sendMessageLinkClick("Link-Click-Events", LocalDateTime.now().format(formatter).toString(), "Equipment search to Home was clicked.");
			return "redirect:/home";
		}
		
		if (mob != null) {
			kafkaSender.sendMessageLinkClick("Link-Click-Events", LocalDateTime.now().format(formatter).toString(), "Equipment search to Mob Search was clicked.");
			return "redirect:/web/mob";
		}
		
		if (boss != null) {
			kafkaSender.sendMessageLinkClick("Link-Click-Events", LocalDateTime.now().format(formatter).toString(), "Equipment search to Boss Search was clicked.");
			return "redirect:/web/boss";
		}
		
		if (mobdrop != null) {
			kafkaSender.sendMessageLinkClick("Link-Click-Events", LocalDateTime.now().format(formatter).toString(), "Equipment search to Mob Drop Search was clicked.");
			return "redirect:/web/drop/mob";
		}
		
		if (bossdrop != null) {
			kafkaSender.sendMessageLinkClick("Link-Click-Events", LocalDateTime.now().format(formatter).toString(), "Equipment search to Boss Drop Search was clicked.");
			return "redirect:/web/drop/boss";
		}
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(25);
		
		String eName = "";
		List<String> eType = new ArrayList<>();
		int eLevel = 0;
		int eWarrior = 0;
		int eMagician = 0;
		int eThief = 0;
		int eArcher = 0;
		int ePirate = 0;
		int eCommon = 0;
		int eBeginner = 0;
		
		Page<Equipment> equipPage;
		
		if (equipmentName == null && equipmentType == null && minimumLevel == null && warrior == null && magician == null && thief == null && archer == null && pirate == null && common == null && beginner == null) {
			
			equipPage = equipmentService.findAllWeb(PageRequest.of(currentPage - 1, pageSize));
		} else {
			
			if (equipmentType == null) {
				eType = new ArrayList<>();
			} else {
				eType = equipmentType;
			}
			
			eName = equipmentName;
			eLevel = minimumLevel;
			eWarrior = warrior;
			eMagician = magician;
			eThief = thief;
			eArcher = archer;
			ePirate = pirate;
			eCommon = common;
			eBeginner = beginner;
			
			
			UserSearchQueryEquipment uEquipSearch = new UserSearchQueryEquipment(eName, eType, eLevel, eWarrior, eMagician, eThief, eArcher, ePirate, eBeginner, eCommon);
			kafkaSender.sendMessageEquipmentSearch("Equipment-Search-Choices", LocalDateTime.now().format(formatter).toString(), uEquipSearch);
			
			equipPage = equipmentService.findAllByQuery(PageRequest.of(currentPage - 1, pageSize), uEquipSearch);
			
			
			
		}
		
		model.addAttribute("equipPage", equipPage);
		model.addAttribute("currentPage", currentPage);
		
		//Filters
		model.addAttribute("equipNameFilter", eName);
		model.addAttribute("equipmentTypeFilter", eType);
		model.addAttribute("levelFilter", eLevel);
		model.addAttribute("warriorFilter", eWarrior);
		model.addAttribute("magicianFilter", eMagician);
		model.addAttribute("thiefFilter", eThief);
		model.addAttribute("archerFilter", eArcher);
		model.addAttribute("pirateFilter", ePirate);
		model.addAttribute("commonFilter", eCommon);
		model.addAttribute("beginnerFilter", eBeginner);
		
		int totalPages = equipPage.getTotalPages();
		
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
												.boxed()
												.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		
		
		return "equipment";
	}
}
