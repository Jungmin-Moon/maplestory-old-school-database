package com.artaleDB.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.artaleDB.dto.DatabaseUpdates;

public interface UpdatesRepository extends JpaRepository<DatabaseUpdates, Long>{
	
	List<DatabaseUpdates> queryFirst7ByPostedDateLessThanEqualOrderByUpdateIdDesc(LocalDateTime dateTime);
}
