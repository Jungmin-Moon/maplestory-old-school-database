package com.artaleDB.services;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Mob;
import com.artaleDB.entities.NoMobsFoundException;
import com.artaleDB.repositories.MobRepository;

@Service
public class MobService {
	
	MobRepository mobRepo;
	
	MobService(MobRepository mobRepo) {
		this.mobRepo = mobRepo;
	}
	
	
	public Iterable<Mob> viewMobList() {
		return mobRepo.findAll();
	}
	
	public Mob findByName(String name) {
		return mobRepo.findByName(name).orElseThrow(() -> new NoMobsFoundException(name));
	}
	
	public Iterable<Mob> findByPartialMatch(String name) {
		Iterable<Mob> check = mobRepo.findByPartialMatch(name);
		
		if (StreamSupport.stream(check.spliterator(), false).count() > 0) {
			return check;
		} else {
			throw new NoMobsFoundException(name);
		}
	}
}
