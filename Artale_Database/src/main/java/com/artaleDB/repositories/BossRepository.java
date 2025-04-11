package com.artaleDB.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Boss;

@Repository
public interface BossRepository extends JpaRepository<Boss, Long>{
	
	//Queries for REST endpoints that will be exposed
	@Query("SELECT b FROM Boss b WHERE b.bossName = :name")
	Optional<Boss> findByName(String name);
	
	@Query("SELECT b FROM Boss b WHERE b.bossName LIKE %:name%")
	Iterable<Boss> findByPartialMatch(String name);
	
	Iterable<Boss> findByBossLocation(String location);
	
	Iterable<Boss> findByBossLevelEquals(int level);
	
	//Boss Repsawns are represented in terms of minutes
	Iterable<Boss> findAllByBossMinRespawnGreaterThanEqual(int respawnTime);
	
	Iterable<Boss> findAllByBossMaxRespawnGreaterThanEqual(int respawnTime);
		
	//Non REST endpoints queries
	Iterable<Boss> findAllByOrderByBossLevelAsc();
	
	Iterable<Boss> findAllByOrderByBossLevelDesc();
	
	Iterable<Boss> findAllByOrderByBossHPAsc();
	
	Iterable<Boss> findAllByOrderByBossHPDesc();
	
	Iterable<Boss> findAllByOrderByBossMinRespawnAsc();
	
	Iterable<Boss> findAllByOrderByBossMinRespawnDesc();
	
	Iterable<Boss> findAllByOrderByBossMaxRespawnAsc();
	
	Iterable<Boss> findAllByOrderByBossMaxRespawnDesc();
}
