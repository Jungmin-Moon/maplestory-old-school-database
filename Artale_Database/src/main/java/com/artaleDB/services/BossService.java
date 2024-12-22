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
	
	//level asc|desc, hp asc|desc
	public List<Boss> getAll() {
		return bossRepo.findAll();
	}
	
	public Optional<Boss> returnById(long id) {
		return bossRepo.findById(id);
	}
	
	public List<Boss> returnBossByName(String name) {
		return bossRepo.getByName(name);
	}
	
	public List<Boss> returnBossByLocation(String location) {
		return bossRepo.getByLocations(location);
	}
	
	
}	
