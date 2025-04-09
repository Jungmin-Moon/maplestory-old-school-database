package com.artaleDB.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Mob;

@Repository
public interface MobRepository extends JpaRepository<Mob, Long>{
	
	//Exposed REST endpoint queries
	@Query("SELECT m FROM Mob m WHERE m.mobName = :name")
	Optional<Mob> findByName(String name);
	
	@Query("SELECT m FROM Mob m WHERE m.mobName LIKE %:name%")
	Iterable<Mob> findByPartialMatch(String name);
	//combine the location queries
	Iterable<Mob> findByMobLocation(String location);
	
	Iterable<Mob> findByMobLocationTwo(String location);
	
	Iterable<Mob> findByMobLevelEquals(int level);
	
	Iterable<Mob> findAllByMobEXPGreaterThanEqual(int expMin);
	
	Iterable<Mob> findAllByMobEXP(int exp);
	
	Iterable<Mob> findAllByMobMinMesoGreaterThanEqual(int meso);
	
	Iterable<Mob> findAllByMobMaxMesoGreaterThanEqual(int meso);
	
	
	//Non exposed queries 
	Iterable<Mob> findAllByOrderByMobLevelAsc();
	
	Iterable<Mob> findAllByOrderByMobLevelDesc();
	
	Iterable<Mob> findAllByOrderByMobEXPAsc();
	
	Iterable<Mob> findAllByOrderByMobEXPDesc();
}
