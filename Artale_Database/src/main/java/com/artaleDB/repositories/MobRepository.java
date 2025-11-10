package com.artaleDB.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Mob;

/*
 * Repository interface for various queries that are of most use to a user for the REST controller MobController
 */
@Repository
public interface MobRepository extends JpaRepository<Mob, Long>{
	
	//Exposed REST endpoint queries
	
	/*
	 * Query that searches for a mob with the exact name given
	 */
	@Query("SELECT m FROM Mob m WHERE m.mobName = :name")
	Optional<Mob> findByName(String name);
	
	/*
	 * Query that searchs for mobs that contain the substring provided
	 */
	@Query("SELECT m FROM Mob m WHERE m.mobName LIKE %:name%")
	Iterable<Mob> findByPartialMatch(String name);
	
	//combine the location queries
	/*
	 * Query that searches in both location columns for mobs to return mobs that are in the location provided either as Location one or Location two
	 */
	Iterable<Mob> findByMobLocationOrMobLocationTwo(String location, String locationTwo);
	
	//Iterable<Mob> findByMobLocationTwo(String location);
	
	/*
	 * Query that returns mobs with level exactly equal to the one provided
	 */
	Iterable<Mob> findByMobLevelEquals(int level);
	
	/*
	 * Query that returns mobs that give exp greater than or equal to the one provided
	 */
	Iterable<Mob> findAllByMobEXPGreaterThanEqual(int expMin);
	
	/*
	 * Query that returns mobs that give exactly the same exp amount provided
	 */
	Iterable<Mob> findAllByMobEXP(int exp);
	
	/*
	 * Query that returns mobs with a minimum meso drop greater than or equal to the one provided
	 */
	Iterable<Mob> findAllByMobMinMesoGreaterThanEqual(int meso);
	
	/*
	 * Query that returns mobs with a maximum meso drop greater than or equal to the one provided
	 */
	Iterable<Mob> findAllByMobMaxMesoGreaterThanEqual(int meso);
	
	//Web Query
	List<Mob> findAllByOrderByMobLevelAsc();
	
	@Query("SELECT m FROM Mob m WHERE m.mobLevel >= :mobLevel AND m.mobName LIKE %:mobName% AND m.mobEXP >= :mobEXP AND m.mobLocation LIKE %:mobLocationOne% AND m.mobLocationTwo LIKE %:mobLocationTwo% ORDER BY m.mobLevel ASC")
	List<Mob> findUsingUserQuery(String mobName, int mobLevel, int mobEXP, String mobLocationOne, String mobLocationTwo);
	
	//SELECT m FROM Mob m WHERE m.mobName LIKE %:mobName% AND m.mobLevel >= :mobLevel AND m.mobEXP >= :mobEXP AND m.mobLocation LIKE %:mobLocationOne% OR m.mobLocationTwo LIKE %:mobLocationTwo%
	//Non exposed queries 
	//Iterable<Mob> findAllByOrderByMobLevelAsc();
	
	//Iterable<Mob> findAllByOrderByMobLevelDesc();
	
	Iterable<Mob> findAllByOrderByMobEXPAsc();
	
	Iterable<Mob> findAllByOrderByMobEXPDesc();
}
