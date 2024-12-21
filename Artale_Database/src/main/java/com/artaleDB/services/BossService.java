package com.artaleDB.services;

import org.springframework.stereotype.Service;

import com.artaleDB.repositories.MobRepository;

@Service
public class BossService {

	MobRepository mobRepo;
	CalculationService calcService;
	ListPrintService listPrintService;
	
	BossService(MobRepository mobRepo, CalculationService calcService, ListPrintService listPrintService) {
		this.mobRepo = mobRepo;	
		this.calcService = calcService;
		this.listPrintService = listPrintService;
	}
}	
