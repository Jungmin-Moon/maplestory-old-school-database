package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Mob;

@Repository
public interface MobRepository extends JpaRepository<Mob, Long>{
	
	
}
