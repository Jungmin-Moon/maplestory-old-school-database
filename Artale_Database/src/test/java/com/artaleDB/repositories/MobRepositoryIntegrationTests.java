package com.artaleDB.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.artaleDB.entities.Mob;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MobRepositoryIntegrationTests {
	
	@Autowired
	MobRepository mobRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	
	@Test
	void givenNewMobWhenSaveThenSuccess() {
		Mob newMob = new Mob();
		
		//newMob.setId(203);
		newMob.setMobName("TEST");
		newMob.setMobEXP(0);
		newMob.setMobHP(0);
		newMob.setMobLevel(0);
		newMob.setMobLocation("tesLocation");
		newMob.setMobLocationTwo("test_location two");
		newMob.setMobMaxMeso(0);
		newMob.setMobMinMeso(0);
		newMob.setMobMP(0);
		newMob.setMobNeededAccuracy(0);
		
		mobRepository.save(newMob);
		
		//assertThat(entityManager.find(Mob.class, insertedMob.getId())).isEqualTo(newMob);
		
		assertThat(mobRepository.findById(newMob.getId())).isEqualTo(newMob.getId());
	}
}
