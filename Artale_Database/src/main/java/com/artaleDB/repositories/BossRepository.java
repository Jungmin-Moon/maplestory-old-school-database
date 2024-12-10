package com.artaleDB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artaleDB.entities.Boss;

@Repository
public interface BossRepository extends JpaRepository<Boss, Long>{
	
}
