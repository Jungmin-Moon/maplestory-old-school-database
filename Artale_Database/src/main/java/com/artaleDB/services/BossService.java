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
	
	public List<Boss> returnBossByHPAsc() {
		return bossRepo.getByBossHPAsc();
	}
	
	public List<Boss> returnBossByHPDesc() {
		return bossRepo.getByBossHPDesc();
	}
	
	public List<Boss> returnBossByLevelAsc() {
		return bossRepo.getByLevelAsc();
	}
	
	public List<Boss> returnBossByLevelDesc() {
		return bossRepo.getByLevelDesc();
	}
	
	public List<Boss> returnBossByMaxRespawnAsc() {
		return bossRepo.getByBossMaxRespawnAsc();
	}
	
	public List<Boss> returnBossByMaxRespawnDesc() {
		return bossRepo.getByBossMaxRespawnDesc();
	}
	
	public List<Boss> returnBossByMinRespawnAsc() {
		return bossRepo.getByBossMinRespawnAsc();
	}
	
	public List<Boss> returnBossByMinRespawnDesc() {
		return bossRepo.getByBossMinRespawnDesc();
	}
	
	public List<Boss> returnBossByMaxRespawnLimit(int time) {
		return bossRepo.getBossMaxRespawnLimit(time);
	}
	
	public List<Boss> returnBossByMinRespawnLimit(int time) {
		return bossRepo.getBossMinRespawnLimit(time);
	}
}	
