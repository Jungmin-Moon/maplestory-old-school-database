package com.artaleDB.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artaleDB.entities.MobDrops;

public interface MobDropRepository extends JpaRepository<MobDrops, Long>{
	
	List<MobDrops> findAllByMobName(String mobName);
	
	List<MobDrops> findAllByEquipmentName(String equipmentName);
}
