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
	
	
	
}
