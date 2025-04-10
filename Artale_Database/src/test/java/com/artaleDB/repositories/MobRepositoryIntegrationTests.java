package com.artaleDB.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

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
	
	//@Autowired
	//TestEntityManager entityManager;
	
	
	@Test
	void succeedWhenFindCorrectMob() {
		Optional<Mob> testMob = mobRepository.findByName("Red Snail");
		
		assertNotNull(testMob);
		
		assertTrue(testMob.isPresent());
		
		assertEquals("Red Snail", testMob.get().getMobName());
		
		Long testId = testMob.get().getId();
		
		assertEquals(4L, testId);
	}
}
