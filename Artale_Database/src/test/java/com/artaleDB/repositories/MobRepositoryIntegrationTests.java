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
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.artaleDB.entities.Mob;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MobRepositoryIntegrationTests {
	
	@Autowired
	MobRepository mobRepository;
	
	//@Autowired
	//TestEntityManager entityManager;
	
	
	@Test
	void succeedWhenFindCorrectMobByName() {
		Optional<Mob> testMob = mobRepository.findByName("Red Snail");
		
		assertNotNull(testMob);
		
		assertTrue(testMob.isPresent());
		
		assertEquals("Red Snail", testMob.get().getMobName());
		
		Long testId = testMob.get().getId();
		
		assertEquals(4L, testId);
	}
	
	@Test
	void succeedWhenFindCorrectNumberMobsByPartialMatch() {
		Iterable<Mob> mobsPartialNameMatch = mobRepository.findByPartialMatch("mush");
		
		long count = StreamSupport.stream(mobsPartialNameMatch.spliterator(), false).count();
		
		//currently 6 mobs in the database contain the substring mush
		assertTrue(count == 6);
	}
	
	@Test
	void succeedWhenFindCorrectNumberMobsByLevel() {
		Iterable<Mob> listByLevel = mobRepository.findByMobLevelEquals(48);
		
		long count = StreamSupport.stream(listByLevel.spliterator(), false).count();
		
		//there should currently be three in the database with the level 48
		assertTrue(count == 3);
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberMobsByLocationOne() {
		Iterable<Mob> listByLocationOne = mobRepository.findByMobLocationAndMobLocationTwo("Victoria Island");
		
		long count = StreamSupport.stream(listByLocationOne.spliterator(), false).count();
		
		//list of mobs with location one being Victoria island should be 59
		assertTrue(count == 59);
	}
	
	/* Due to changing of repository this test is no longer needed.
	@Test
	void succeedWhenFindCorrectNumberMobsByLocationTwo() {
		Iterable<Mob> listByLocationTwo = mobRepository.findByMobLocationTwo("");
		
		long count = StreamSupport.stream(listByLocationTwo.spliterator(), false).count();
		
		//list of mobs in the database with an empty string for mob location two should be 196 at the moment
		ssertTrue(count == 196);
	} */
	
	@Test
	void succeedWhenFindCorrectNumberMobsByEXP() {
		Iterable<Mob> listByEXP = mobRepository.findAllByMobEXP(110);
		
		long count = StreamSupport.stream(listByEXP.spliterator(), false).count();
		
		//list of mobs in the database that give 110 exp per kill is only 8 at the moment
		assertTrue(count == 8);
	}
	
	@Test
	void succeedWhenFindCorrectNumberMobsByEXPGreaterThanEqual() {
		Iterable<Mob> listByMobEXPGreaterEqual = mobRepository.findAllByMobEXPGreaterThanEqual(78);
		
		long count = StreamSupport.stream(listByMobEXPGreaterEqual.spliterator(), false).count();
		
		//number of mobs fulfilling this should be 138 at the moment
		assertTrue(count == 138);
	}
	
	@Test
	void succeedWhenFindCorrectNumberMobsByMinMesoGreaterThanEqual() {
		Iterable<Mob> listByMobMinMesoGreaterEqual = mobRepository.findAllByMobMinMesoGreaterThanEqual(178);
		
		long count = StreamSupport.stream(listByMobMinMesoGreaterEqual.spliterator(), false).count();
		
		//currently 84 mobs give a minimum meso value greater than or equal to 178
		assertTrue(count == 84);
	}
	
	@Test
	void succeedWhenFindCorrectNumberMobsByMaxmesoGreaterThanEqual() {
		Iterable<Mob> listByMobMaxMesoGreaterEqual = mobRepository.findAllByMobMaxMesoGreaterThanEqual(245);
		
		long count = StreamSupport.stream(listByMobMaxMesoGreaterEqual.spliterator(), false).count();
		
		//currently 94 mobs give a maximum meso value greater than or equal to 245
		assertTrue(count == 94);
	}
}
