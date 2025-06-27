package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artaleDB.entities.BossDrops;

public interface BossDropRepository extends JpaRepository<BossDrops, Long>{
	
	List<BossDrops> findAllByBossName(String bossName);
	
	List<BossDrops> findAllByEquipmentName(String equipmentName);
}
