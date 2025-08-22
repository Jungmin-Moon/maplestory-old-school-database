package com.artaleDB.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.artaleDB.dto.AdminUpdates;
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
	
	
	public List<String> convertTime(List<DatabaseUpdates> updates) {
		List<String> timeConverted = new ArrayList<>();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm");
		
		timeConverted = updates.stream().map(time -> time.getPostedDate().format(formatter)).collect(Collectors.toList());
		
		return timeConverted;
	}
	
	public List<AdminUpdates> makeReadable(List<DatabaseUpdates> updates, List<String> convertedTimes) {
		List<AdminUpdates> readableUpdates = new ArrayList<>();
		
		for (int i = 0; i < updates.size(); i++) {
			AdminUpdates adminUpdates = new AdminUpdates(updates.get(i).getUpdateText(), convertedTimes.get(i));
			readableUpdates.add(adminUpdates);
		}
		
		
		return readableUpdates;
	}
}
