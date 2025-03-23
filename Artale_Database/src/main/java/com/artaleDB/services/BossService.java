package com.artaleDB.services;

import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.Boss;
import com.artaleDB.entities.NoneFoundException;
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
	
	public Iterable<Boss> findByName(String name) {
		Iterable<Boss> checkName = bossRepo.findByName(name);
		long count = StreamSupport.stream(checkName.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses were found with the name: " + name + " in the database.");
		} else {
			return checkName;
		}
	}
	
	public Iterable<Boss> findByPartialMatch(String name) {
		Iterable<Boss> checkNames = bossRepo.findByPartialMatch(name);
		long count = StreamSupport.stream(checkNames.spliterator(), false).count();
		
		if (count <= 0) {
			throw new NoneFoundException("No bosses were found similar to the name: " + name + " in the database.");
		} else {
			return checkNames;
		}
	}
}	
