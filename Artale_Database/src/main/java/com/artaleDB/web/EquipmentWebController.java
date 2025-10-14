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
							@RequestParam(required = false) Integer common, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, @RequestParam("equipmentName") Optional<String> equipName,
							@RequestParam("equipmentType") Optional<List<String>> equipType, @RequestParam("minimumLevel") Optional<Integer> level, @RequestParam("warrior") Optional<Integer> war, 
							@RequestParam("magician") Optional<Integer> mag, @RequestParam("thief") Optional<Integer> thf, @RequestParam("archer") Optional<Integer> arc, @RequestParam("pirate") Optional<Integer> pir, 
							@RequestParam("common") Optional<Integer> comm, @RequestParam("beginner") Optional<Integer> beg) {
		
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
		int pageSize = size.orElse(30);
		
		//Used for URL creation and to make sure queries are kept intact
		String eName = equipName.orElse("");
		List<String> eType = equipType.orElse(equipmentType);
		int minLevel = level.orElse(0);
		int classWar = war.orElse(0);
		int classMagician = mag.orElse(0);
		int classThief = thf.orElse(0);
		int classArcher = arc.orElse(0);
		int classPirate = pir.orElse(0);
		int classCommon = comm.orElse(0);
		int classBeginner = beg.orElse(0);
		
		Page<Equipment> equipPage;
		
		if (equipmentType == null ||minimumLevel == null || warrior == null || magician == null || thief == null || archer == null || pirate == null || beginner == null || common == null) {
			minimumLevel = warrior = magician = thief = archer = pirate = beginner = common = 0;
			equipmentType = new ArrayList<>();
			
			equipPage = equipmentService.findAllWeb(PageRequest.of(currentPage - 1, pageSize));
			
		} else {
			
			UserSearchQueryEquipment uSearchEquip = new UserSearchQueryEquipment(eName, eType, minLevel, classWar, classMagician, classThief, classArcher, classPirate, classBeginner, classCommon);
			
			kafkaSender.sendMessageEquipmentSearch("Equipment-Search-Choices", LocalDateTime.now().format(formatter).toString(), uSearchEquip);
			
			equipPage = equipmentService.findAllByQuery(PageRequest.of(currentPage - 1, pageSize), uSearchEquip);	
			
			System.out.println(equipmentType.toString());
		}
		
		int totalPages = equipPage.getTotalPages();
		
		
		model.addAttribute("equipPage", equipPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("equipName", eName);
		model.addAttribute("equipmentTypeQuery", eType);
		model.addAttribute("level", minLevel);
		model.addAttribute("warrior", classWar);
		model.addAttribute("magician", classMagician);
		model.addAttribute("thief", classThief);
		model.addAttribute("archer", classArcher);
		model.addAttribute("pirate", classPirate);
		model.addAttribute("common", classCommon);
		model.addAttribute("beginner", classBeginner);
		
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
												.boxed()
												.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		
		return "equipment";
	}
}
