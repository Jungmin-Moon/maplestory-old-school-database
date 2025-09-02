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

import com.artaleDB.dto.UserSearchQueryBoss;
import com.artaleDB.entities.Boss;
import com.artaleDB.services.BossService;

@Controller
@RequestMapping("/web/boss")
public class BossWebController {
	
	BossService bossService;
	
	BossWebController(BossService bossService) {
		this.bossService = bossService;	
	}
	
	
	@GetMapping
	public String bossHome(Model model, @RequestParam (required = false) String home, @RequestParam (required = false) String mob,
							@RequestParam (required = false) String equipment, @RequestParam (required = false) String mobdrop, @RequestParam (required = false) String bossdrop,
							@RequestParam(required = false) String bossName, @RequestParam(required = false) Integer bossLevel, @RequestParam(required = false) Integer bossMinRespawn, 
							@RequestParam(required = false) Integer bossMaxRespawn, @RequestParam(required = false) String bossLocation,
							@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
		if (home != null) {
			return "redirect:/home";
		}
		
		if (mob != null) {
			return "redirect:/web/mob";
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
		
		Page<Boss> bossPage;
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		String bName = "";
		int bLevel = 0;
		int bMinRespawn = 0;
		int bMaxRespawn = 0;
		String bLocation = "";
		
		if (bossName == null && bossLevel == null && bossMinRespawn == null && bossMaxRespawn == null && bossLocation == null) {
			bossPage = bossService.findAllBossWeb(PageRequest.of(currentPage - 1, pageSize));
		} else {
			UserSearchQueryBoss uSearch = new UserSearchQueryBoss(bossName, bossLevel, bossMinRespawn, bossMaxRespawn, bossLocation);
			bossPage = bossService.findByUserQueryBossWeb(uSearch.getBossName(), uSearch.getBossLevel(), uSearch.getBossMinRespawn(), 
					uSearch.getBossMaxRespawn(), uSearch.getBossLocation(), PageRequest.of(currentPage - 1, pageSize));
			
			bName = bossName;
			bLevel = bossLevel;
			bMinRespawn = bossMinRespawn;
			bMaxRespawn = bossMaxRespawn;
			bLocation = bossLocation;
			
		}
		
		model.addAttribute("bossPage", bossPage);
		
		int totalPage = bossPage.getTotalPages();
		
		if (totalPage > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
												.boxed()
												.collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		
		return "bosses.html";
	}
}
