package com.artaleDB.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.artaleDB.entities.Mob;

@DataJpaTest
public class MobRepositoryIntegrationTests {
	
	@Autowired
	MobRepository mobRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	
	@Test
	void givenNewMobWhenSaveThenSuccess() {
		Mob newMob = new Mob();
		
		newMob.setId(203);
		newMob.setMobName("TEST");
		
		Mob insertedMob = mobRepository.save(newMob);
		
		assertThat(entityManager.find(Mob.class, insertedMob.getId())).isEqualTo(newMob);
	}
}
