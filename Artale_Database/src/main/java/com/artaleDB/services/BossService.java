package com.artaleDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Boss;
import com.artaleDB.repositories.BossRepository;

@Service
public class BossService {

	BossRepository bossRepo;
	
	BossService(BossRepository bossRepo) {
		this.bossRepo = bossRepo;	
	}
	
	public Iterable<Boss> viewBossList() {
		return bossRepo.findAll();
	}
	
	
}	
