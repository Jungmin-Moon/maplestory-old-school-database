package com.artaleDB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artaleDB.dto.DatabaseUpdates;

public interface UpdatesRepository extends JpaRepository<DatabaseUpdates, Long>{
	
}
