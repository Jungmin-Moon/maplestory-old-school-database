package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Mob;

@Repository
public interface MobRepository extends JpaRepository<Mob, Long>{
	
	@Query("SELECT m FROM Mob m WHERE m.mobName LIKE %:name%")
	public List<Mob> getByName(String name);
	
	@Query("SELECT m FROM Mob m WHERE m.mobName = :name")
	public Mob getByExactName(String name);
	
	@Query("SELECT m FROM Mob m WHERE m.mobLocation LIKE %:location% or m.mobLocationTwo LIKE %:location%")
	public List<Mob> getByLocations(String location);
	
	@Query("SELECT m FROM Mob m ORDER BY m.mobNeededAccuracy DESC")
	public List<Mob> getByAccuracyDesc();
	
	@Query("SELECT m FROM Mob m ORDER BY m.mobNeededAccuracy ASC")
	public List<Mob> getByAccuracyAsc();
	
	@Query("SELECT m FROM Mob m WHERE m.mobNeededAccuracy <= :limit ORDER BY m.mobNeededAccuracy ASC")
	public List<Mob> getAccuracyAscLimit(int limit);
	
	@Query("SELECT m FROM Mob m WHERE m.mobNeededAccuracy <= :limit ORDER BY m.mobNeededAccuracy Desc")
	public List<Mob> getAccuracyDescLimit(int limit);
	
	@Query("SELECT m FROM Mob m ORDER BY m.mobMaxMeso ASC")
	public List<Mob> getMaxMesoAsc();
	
	@Query("SELECT m FROM Mob m ORDER BY m.mobMaxMeso DESC")
	public List<Mob> getMaxMesoDesc();
	
	@Query("SELECT m FROM Mob m ORDER BY m.mobMinMeso ASC")
	public List<Mob> getMinMesoAsc();
	
	@Query("SELECT m FROM Mob m ORDER BY m.mobMinMeso DESC")
	public List<Mob> getMinMesodesc();
}
