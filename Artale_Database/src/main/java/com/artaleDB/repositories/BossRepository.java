package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Boss;

@Repository
public interface BossRepository extends JpaRepository<Boss, Long>{
	
	
	@Query("SELECT b FROM Boss b WHERE b.bossName = :name")
	Iterable<Boss> findByName(String name);
	
	@Query("SELECT b FROM Boss b WHERE b.bossName LIKE %:name%")
	Iterable<Boss> findByPartialMatch(String name);
	
	Iterable<Boss> findByBossLocation(String location);
	
	Iterable<Boss> findByBossLevelEquals(int level);
	
	Iterable<Boss> findAllByOrderByBossLevelAsc();
	
	Iterable<Boss> findAllByOrderByBossLevelDesc();
	
	Iterable<Boss> findAllByOrderByBossHPAsc();
	
	Iterable<Boss> findAllByOrderByBossHPDesc();
	
	Iterable<Boss> findAllByBossMinRespawnGreaterThanEqual(int respawnTime);
	
	Iterable<Boss> findAllByBossMaxRespawnGreaterThanEqual(int respawnTime);
	
	Iterable<Boss> findAllByOrderByBossMinRespawnAsc();
	
	Iterable<Boss> findAllByOrderByBossMaxRespawnDesc();
}
