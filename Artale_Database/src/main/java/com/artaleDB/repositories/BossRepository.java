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
	List<Boss> findByPartialMatch(String name);
	
	/*Query to find bosses who are in the location provided. */
	List<Boss> findByBossLocation(String location);
	
	/*Query to find bosses who have the same level as the one provided */
	List<Boss> findByBossLevelEquals(int level);
	
	/*Finds bosses who minimum or maximum respawn time is greater than or equal to the one provided. These are in minutes.*/
	List<Boss> findAllByBossMinRespawnGreaterThanEqual(int respawnTime);
	
	List<Boss> findAllByBossMaxRespawnGreaterThanEqual(int respawnTime);
	
	
	@Query("SELECT b FROM Boss b WHERE b.bossName LIKE %:bossName% AND b.bossLevel >= :bossLevel AND b.bossMinRespawn >= :bossMinRespawn AND b.bossMaxRespawn >= :bossMaxRespawn AND b.bossLocation LIKE %:bossLocation% ORDER BY b.bossLevel ASC")
	List<Boss> findByUsingUserQuery(String bossName, int bossLevel, int bossMinRespawn, int bossMaxRespawn, String bossLocation);
	
	//Non REST endpoints queries
	List<Boss> findAllByOrderByBossLevelAsc();
	
	List<Boss> findAllByOrderByBossLevelDesc();
	
	List<Boss> findAllByOrderByBossHPAsc();
	
	List<Boss> findAllByOrderByBossHPDesc();
	
	List<Boss> findAllByOrderByBossMinRespawnAsc();
	
	List<Boss> findAllByOrderByBossMinRespawnDesc();
	
	List<Boss> findAllByOrderByBossMaxRespawnAsc();
	
	List<Boss> findAllByOrderByBossMaxRespawnDesc();
}
