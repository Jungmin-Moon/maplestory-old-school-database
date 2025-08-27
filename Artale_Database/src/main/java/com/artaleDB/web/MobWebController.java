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
							@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size,
							@RequestParam(required = false) String mobName, @RequestParam(required = false) Integer mobLevel, @RequestParam(required = false) Integer mobEXP,
							@RequestParam(required = false) String mobLocationOne, @RequestParam(required = false) String mobLocationTwo) {
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

		String mName = "";
		int mLevel = 0;
		int mEXP = 0;
		String mLocationOne = "";
		String mLocationTwo = "";
		
		Page<Mob> mobPage;
		
		if (mobName == null && mobLevel == null && mobEXP == null && mobLocationOne == null && mobLocationTwo == null) {

			mobPage = mobService.findAllWeb(PageRequest.of(currentPage - 1, pageSize));

		} else {
			
			if (mobEXP == null) {
				mobEXP = 0;
			}
			
			UserSearchQueryMob uMobSearch = new UserSearchQueryMob(mobName, mobLevel, mobEXP, mobLocationOne, mobLocationTwo);
			mobPage = mobService.findByUserQueryMobWeb(uMobSearch.getMobName(), uMobSearch.getMobLevel(), uMobSearch.getMobEXP(), 
																uMobSearch.getMobLocationOne(), uMobSearch.getMobLocationTwo(), PageRequest.of(currentPage - 1, pageSize));
			mName = mobName;
			mLevel = mobLevel;
			mEXP = mobEXP;
			mLocationOne = mobLocationOne;
			mLocationTwo = mobLocationTwo;
			
		}

		model.addAttribute("mobPage", mobPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("mobLevelFilter", mLevel);
		model.addAttribute("mobNameFilter", mName);
		model.addAttribute("mobExpFilter", mEXP);
		model.addAttribute("mobLocationOneFilter",mLocationOne);
		model.addAttribute("mobLocationTwoFilter", mLocationTwo);
		int totalPages = mobPage.getTotalPages();
	
		if (totalPages > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
											.boxed()
											.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		return "mobs.html";
	}
	
}