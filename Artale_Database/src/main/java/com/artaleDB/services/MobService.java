package com.artaleDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Mob;
import com.artaleDB.repositories.MobRepository;

@Service
public class MobService {
	
	MobRepository mobRepo;
	
	MobService(MobRepository mobRepo) {
		this.mobRepo = mobRepo;
	}
	
	
	public List<Mob> getAll() {
		return mobRepo.findAll();
	}
	
	public Optional<Mob> returnById(long id) {
		return mobRepo.findById(id);
	}
	
	public List<Mob> returnListByName(String name) {
		return mobRepo.getByName(name);
	}
	
	public Mob returnByExactName(String name) {
		return mobRepo.getByExactName(name);
	}
	
	public List<Mob> returnListByLocation(String location) {
		return mobRepo.getByLocations(location);
	}
	
	public List<Mob> returnListByAccuracyAsc() {
		return mobRepo.getByAccuracyAsc();
	}
	
	public List<Mob> returnListByAccuracyDesc() {
		return mobRepo.getByAccuracyDesc();
	}
	
	public List<Mob> returnListByAccuracyAscLimit(int limit) {
		return mobRepo.getAccuracyAscLimit(limit);
	}
	
	public List<Mob> returnListByAccuracyDescLimit(int limit) {
		return mobRepo.getAccuracyDescLimit(limit);
	}
	
	public List<Mob> returnListByMaxMesoAsc() {
		return mobRepo.getMaxMesoAsc();
	}
	
	public List<Mob> returnListByMaxMesoDesc() {
		return mobRepo.getMaxMesoDesc();
	}
	
	public List<Mob> returnListByMinMesoAsc() {
		return mobRepo.getMinMesoAsc();
	}
	
	public List<Mob> returnListByMinMesoDesc() {
		return mobRepo.getMinMesodesc();
	}
}
