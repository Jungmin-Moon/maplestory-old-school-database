package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Boss;

@Repository
public interface BossRepository extends JpaRepository<Boss, Long>{
	
	
	@Query("SELECT b from Boss b where b.bossName like %:name%")
	public List<Boss> getByName(String name);
	
	
	@Query("SELECT b from Boss b where b.bossLocation like %:location%")
	public List<Boss> getByLocations(String location);
}
