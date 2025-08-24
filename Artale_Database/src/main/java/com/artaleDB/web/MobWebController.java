package com.artaleDB.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artaleDB.dto.UserSearchQueryMob;
import com.artaleDB.entities.Mob;
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
							@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop,
							@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		if (home != null) {
			return "redirect:/home";
		}
		
		if (boss != null) {
			return "redirect:/web/boss";
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
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(20);
		
		//var mobsAll = mobService.findAllWeb();
		Page<Mob> mobPage = mobService.findAllWeb(PageRequest.of(currentPage - 1, pageSize));
		
		model.addAttribute("mobPage", mobPage);
		model.addAttribute("currentPage", currentPage);		
		int totalPages = mobPage.getTotalPages();
		
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
												.boxed()
												.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		//model.addAttribute("allMobs", mobsAll);
		
		return "mobs.html";
	}
	
	@PostMapping
	public String afterSearchMob(Model model, @RequestParam (required = false) String home, @RequestParam (required = false) String boss, 
			@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, 
			@RequestParam (required = false) String bossdrop, UserSearchQueryMob uMobSearch) {
		
		if (home != null) {
			return "redirect:/home";
		}
		
		if (boss != null) {
			return "redirect:/web/boss";
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
		
		var userMobSearch = mobService.findByUserQueryMobWeb(uMobSearch.getMobName(), uMobSearch.getMobLevel(), uMobSearch.getMobEXP(), 
															uMobSearch.getMobLocationOne(), uMobSearch.getMobLocationTwo());
		
		model.addAttribute("allMobs", userMobSearch);
		
		return "mobs.html";
	}
}
