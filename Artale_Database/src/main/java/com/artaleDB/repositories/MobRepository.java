package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Mob;

@Repository
public interface MobRepository extends JpaRepository<Mob, Long>{
	
	@Query("SELECT m from Mob m where m.mobName like %:name%")
	public List<Mob> getByName(String name);
	
	@Query("SELECT m from Mob m where m.mobLocation like %:location% or m.mobLocationTwo like %:location%")
	public List<Mob> getByLocations(String location);
	
	@Query("SELECT m from Mob m order by m.mobNeededAccuracy DESC")
	public List<Mob> getByAccuracyDesc();
	
	@Query("SELECT m from Mob m order by m.mobNeededAccuracy ASC")
	public List<Mob> getByAccuracyAsc();
	
	@Query("SELECT m from Mob m where m.mobNeededAccuracy <= :limit order by m.mobNeededAccuracy ASC")
	public List<Mob> getAccuracyAscLimit(int limit);
	
	@Query("SELECT m from Mob m where m.mobNeededAccuracy <= :limit order by m.mobNeededAccuracy Desc")
	public List<Mob> getAccuracyDescLimit(int limit);
	
	@Query("SELECT m from Mob m order by m.mobMaxMeso ASC")
	public List<Mob> getMaxMesoAsc();
	
	@Query("SELECT m from Mob m order by m.mobMaxMeso DESC")
	public List<Mob> getMaxMesoDesc();
	
	@Query("SELECT m from Mob m order by m.mobMinMeso ASC")
	public List<Mob> getMinMesoAsc();
	
	@Query("SELECT m from Mob m order by m.mobMinMeso DESC")
	public List<Mob> getMinMesodesc();
}
