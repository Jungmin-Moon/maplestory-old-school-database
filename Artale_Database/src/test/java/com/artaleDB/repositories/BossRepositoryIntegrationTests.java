package com.artaleDB.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BossRepositoryIntegrationTests {

	@Autowired
	BossRepository bossRepository;
	
	
	
	@Test
	void succeedWhenFindCorrectMobByName() {
		
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberOfBossesPartialMatch() {
		
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberByLocation() {
		
	}
	
	@Test
	void succeedWhenFindCorrectNumberByLevel() {
		
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberByMinRespawnGreaterThanEqual() {
		
	}
	
	@Test
	void succeedWhenFindCorrectNumberByMaxRespawnGreaterThanEqual() {
		
	}
}
