package com.artaleDB.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Mob;

@Repository
public interface MobRepository extends JpaRepository<Mob, Long>{
	
	@Query("SELECT m FROM Mob m WHERE m.mobName = :name")
	Iterable<Mob> findByName(String name);
	
	@Query("SELECT m FROM Mob m WHERE m.mobName LIKE %:name%")
	Iterable<Mob> findByPartialMatch(String name);
	
	
	Iterable<Mob> findByMobLocation(String location);
	
	Iterable<Mob> findByMobLocationTwo(String location);
	
	Iterable<Mob> findByMobLevelEquals(int level);
	
	Iterable<Mob> findAllByOrderByMobLevelAsc();
	
	Iterable<Mob> findAllByOrderByMobLevelDesc();
	
	Iterable<Mob> findAllByOrderByMobExpAsc();
	
	Iterable<Mob> findAllByOrderByMobExpDesc();
	
	Iterable<Mob> findAllByMobExpGreaterThanEqual(int expMin);
	
	Iterable<Mob> findAllByMobExp(int exp);
	
	Iterable<Mob> findAllByMobMinMesoGreaterThanEqual(int meso);
	
	Iterable<Mob> findAllByMobMaxMesoGreaterThanEqual(int meso);
	
	
}
