package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Boss;

@Repository
public interface BossRepository extends JpaRepository<Boss, Long>{
	
	
	@Query("SELECT b FROM Boss b WHERE b.bossName LIKE %:name%")
	public List<Boss> getByName(String name);
	
	
	@Query("SELECT b FROM Boss b WHERE b.bossLocation LIKE %:location%")
	public List<Boss> getByLocations(String location);
	
	@Query("SELECT b FROM Boss b ORDER BY b.bossLevel ASC")
	public List<Boss> getByLevelAsc();
	
	@Query("SELECT b FROM Boss b ORDER BY b.bossLevel DESC")
	public List<Boss> getByLevelDesc();
	
	@Query("SELECT b FROM Boss b ORDER BY b.bossHP ASC")
	public List<Boss> getByBossHPAsc();
	
	@Query("SELECT b FROM Boss b ORDER BY b.bossHP DESC")
	public List<Boss> getByBossHPDesc();
}
