package com.artaleDB.repositories;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.artaleDB.entities.Equipment;



@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EquipmentRepositoryIntegrationTests {

	
	@Autowired
	EquipmentRepository equipmentRepository;
	
	
	@Test
	void correctNumberReturnedForHatsOnly() {
		
		List<String> equipType = new ArrayList<>();
		
		equipType.add("Hat");
		
		List<Equipment> allHats = equipmentRepository.findByQueryParametersOR("", equipType, 0, 0, 0, 0, 0, 0, 0, 0);
		
		assertEquals(279L, allHats.size());
	}
	
	
	@Test
	void correctNumberReturnedForHatsOverallBow() {
		List<String> equipType = new ArrayList<>();
		
		equipType.add("Hat");
		equipType.add("Overall");
		equipType.add("Bow");
		
		List<Equipment> allHatOverallBow = equipmentRepository.findByQueryParametersOR("", equipType, 0, 0, 0, 0, 0, 0, 0, 0);
		
		assertEquals(464L, allHatOverallBow.size());
	}
	
	
}
