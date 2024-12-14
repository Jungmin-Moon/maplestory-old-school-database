package com.artaleDB.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Mob;
import com.artaleDB.repositories.MobRepository;

@Service
public class MobService {
	
	MobRepository mobRepo;
	
	MobService(MobRepository mobRepo) {
		this.mobRepo = mobRepo;
	}
	
	
	List<Mob> getAll() {
		return mobRepo.findAll();
	}
	
	List<Mob> returnListByName(String name) {
		return mobRepo.getByName(name);
	}
	
	List<Mob> returnListByLocation(String location) {
		return mobRepo.getByLocations(location);
	}
	
	List<Mob> returnListByAccuracyAsc() {
		return mobRepo.getByAccuracyAsc();
	}
	
	List<Mob> returnListByAccuracyDesc() {
		return mobRepo.getByAccuracyDesc();
	}
	
	List<Mob> returnListByAccuracyAscLimit(int limit) {
		return mobRepo.getAccuracyAscLimit(limit);
	}
	
	List<Mob> returnListByAccuracyDescLimit(int limit) {
		return mobRepo.getAccuracyDescLimit(limit);
	}
	
	List<Mob> returnListByMaxMesoAsc() {
		return mobRepo.getMaxMesoAsc();
	}
	
	List<Mob> returnListByMaxMesoDesc() {
		return mobRepo.getMaxMesoDesc();
	}
	
	List<Mob> returnListByMinMesoAsc() {
		return mobRepo.getMinMesoAsc();
	}
	
	List<Mob> returnListByMinMesoDesc() {
		return mobRepo.getMinMesodesc();
	}
}
