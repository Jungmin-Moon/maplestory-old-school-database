package com.artaleDB.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.artaleDB.entities.Boss;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BossRepositoryIntegrationTests {

	@Autowired
	BossRepository bossRepository;
	
	
	
	@Test
	void succeedWhenFindCorrectBossByName() {
		Optional<Boss> bossByExactName = bossRepository.findByName("Faust");
		
		assertNotNull(bossByExactName);
		assertTrue(bossByExactName.isPresent());
		
		assertEquals("Faust", bossByExactName.get().getBossName());
		
		assertEquals(5L, bossByExactName.get().getId());
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberOfBossesPartialMatch() {
		Iterable<Boss> bossesThatContain = bossRepository.findByPartialMatch("in");
		
		long count = StreamSupport.stream(bossesThatContain.spliterator(), false).count();
		
		//bosses that contain the substring "in" currently should be equal to 3
		assertTrue(count == 3);
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberByLocation() {
		Iterable<Boss> bossesInLocation = bossRepository.findByBossLocation("Victoria Island");
		
		long count = StreamSupport.stream(bossesInLocation.spliterator(), false).count();
		
		//currently there should be 9 bosses located in Victoria Island
		assertTrue(count == 9);
	}
	
	@Test
	void succeedWhenFindCorrectNumberByLevel() {
		Iterable<Boss> bossesEqualToLevel = bossRepository.findByBossLevelEquals(65);
		
		long count = StreamSupport.stream(bossesEqualToLevel.spliterator(), false).count();
		
		//currently there should be 4 bosses leveled 65 in the database
		assertTrue(count == 4);
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberByMinRespawnGreaterThanEqual() {
		Iterable<Boss> bossesMinRespawnEqual = bossRepository.findAllByBossMinRespawnGreaterThanEqual(45);
		
		long count = StreamSupport.stream(bossesMinRespawnEqual.spliterator(), false).count();
		
		//currently there are 19 bosses with minimum respawn time equal or greater than 45 minutes
		assertTrue(count == 19);
	}
	
	@Test
	void succeedWhenFindCorrectNumberByMaxRespawnGreaterThanEqual() {
		Iterable<Boss> bossesMaxRespawnEqual = bossRepository.findAllByBossMaxRespawnGreaterThanEqual(87);
		
		long count = StreamSupport.stream(bossesMaxRespawnEqual.spliterator(), false).count();
		
		//currently there are 16 bosses with maximum repsawn time equal or greater than 87 minutes
		assertTrue(count == 16);
	}
}
