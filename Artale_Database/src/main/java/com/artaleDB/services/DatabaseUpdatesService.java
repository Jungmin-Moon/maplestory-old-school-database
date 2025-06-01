package com.artaleDB.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.artaleDB.entities.DatabaseUpdates;
import com.artaleDB.repositories.UpdatesRepository;

@Service
public class DatabaseUpdatesService {

	UpdatesRepository updatesRepository;
	
	DatabaseUpdatesService(UpdatesRepository updatesRepository) {
		this.updatesRepository = updatesRepository;	
	}
	
	
	public List<DatabaseUpdates> findAll() {
		return updatesRepository.findAll();
	}
	
	public List<DatabaseUpdates> getlast15Updates(LocalDateTime dateTime) {
		return updatesRepository.queryFirst15ByPostedDateLessThanEqualOrderByUpdateIdDesc(dateTime);
	}
}
