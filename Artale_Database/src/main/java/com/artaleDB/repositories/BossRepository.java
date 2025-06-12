package com.artaleDB.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Boss;
/*
 * Repository holding the queries that are most likely to be used by a user.
 */
@Repository
public interface BossRepository extends JpaRepository<Boss, Long>{
	
	/*Queries for REST endpoints that will be exposed */
	
	/*Query to find a boss with the exact same name as the one given*/
	@Query("SELECT b FROM Boss b WHERE b.bossName = :name")
	Optional<Boss> findByName(String name);
	
	/*Query to find a list of bosses that have the substring provided*/
	@Query("SELECT b FROM Boss b WHERE b.bossName LIKE %:name%")
	Iterable<Boss> findByPartialMatch(String name);
	
	/*Query to find bosses who are in the location provided. */
	Iterable<Boss> findByBossLocation(String location);
	
	/*Query to find bosses who have the same level as the one provided */
	Iterable<Boss> findByBossLevelEquals(int level);
	
	/*Finds bosses who minimum or maximum respawn time is greater than or equal to the one provided. These are in minutes.*/
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
