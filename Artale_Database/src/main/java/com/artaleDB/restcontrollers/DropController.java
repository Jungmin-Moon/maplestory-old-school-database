package com.artaleDB.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artaleDB.services.DropService;

@RestController
@RequestMapping("drops")
public class DropController {

	DropService dropService;
	
	DropController(DropService dropService) {
		this.dropService = dropService;
	}
	
	
	
}
