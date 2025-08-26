package com.artaleDB.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.artaleDB.dto.UserSearchQueryMob;
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
							@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
							@RequestParam(required = false) String mobName, @RequestParam(required = false) Integer mobLevel, @RequestParam(required = false) Integer mobEXP,
							@RequestParam(required = false) String mobLocationOne, @RequestParam(required = false) String mobLocationTwo,
							@RequestParam("level") Optional<Integer> level) {
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
		
		
		if (mobName == null && mobLevel == null && mobEXP == null && mobLocationOne == null && mobLocationTwo == null) {
			int currentPage = page.orElse(1);
			int pageSize = size.orElse(20);

			var mobPage = mobService.findAllWeb(PageRequest.of(currentPage - 1, pageSize));
			
			UserSearchQueryMob uMobSearch = new UserSearchQueryMob("", 0, 0, "", "");
			
			model.addAttribute("mobPage", mobPage);
			model.addAttribute("currentPage", currentPage);
			//model.addAttribute("filter", uMobSearch);
			
			int totalPages = mobPage.getTotalPages();
		
			if (totalPages > 0) {
				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
												.boxed()
												.collect(Collectors.toList());
				model.addAttribute("pageNumbers", pageNumbers);
			}
			
		} else {
			
			UserSearchQueryMob uMobSearch = new UserSearchQueryMob(mobName, mobLevel, mobEXP, mobLocationOne, mobLocationTwo);
			int currentPage = page.orElse(1);
			int pageSize = size.orElse(20);
			
			var userMobSearch = mobService.findByUserQueryMobWeb(uMobSearch.getMobName(), uMobSearch.getMobLevel(), uMobSearch.getMobEXP(), 
																uMobSearch.getMobLocationOne(), uMobSearch.getMobLocationTwo(), PageRequest.of(currentPage - 1, pageSize));

			
			model.addAttribute("mobPage", userMobSearch);
			model.addAttribute("currentPage", currentPage);
			//model.addAttribute("filter", userMobSearch);
			int totalPages = userMobSearch.getTotalPages();
			
			if (totalPages > 0) {
				List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
														.boxed()
														.collect(Collectors.toList());
				model.addAttribute("pageNumbers", pageNumbers);
			}
		}
		return "mobs.html";
	}
	
}