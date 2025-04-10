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
	void succeedWhenFindCorrectNumberMobsByLevel() {
		Iterable<Mob> listByLevel = mobRepository.findByMobLevelEquals(48);
		
		long count = StreamSupport.stream(listByLevel.spliterator(), false).count();
		
		//there should currently be three in the database with the level 48
		assertTrue(count == 3);
	}
	
	
	@Test
	void succeedWhenFindCorrectNumberMobsByLocationOne() {
		Iterable<Mob> listByLocationOne = mobRepository.findByMobLocation("Victoria Island");
		
		long count = StreamSupport.stream(listByLocationOne.spliterator(), false).count();
		
		//list of mobs with location one being Victoria island should be 59
		assertTrue(count == 59);
	}
	
	@Test
	void succeedWhenFindCorrectNumberMobsByLocationTwo() {
		Iterable<Mob> listByLocationTwo = mobRepository.findByMobLocationTwo("");
		
		long count = StreamSupport.stream(listByLocationTwo.spliterator(), false).count();
		
		//list of mobs in the database with an empty string for mob location two should be 196 at the moment
		assertTrue(count == 196);
	}
	
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
	
	
}
