package com.artaleDB.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculationService {

	
	public BigDecimal expPerHour(int mobExp, int numKillPerHour) {
		
		return new BigDecimal(mobExp * numKillPerHour);
		
	}
	
	
	public BigDecimal maxMesoPerHour(String mobMaxMeso, int numKillPerHour) {
		
		if (mobMaxMeso.equalsIgnoreCase("Unknown")) {
			return new BigDecimal(-1);
		} else {
			BigDecimal bigDecimalMaxMeso = new BigDecimal(mobMaxMeso);
			BigDecimal bigDecimalKills = new BigDecimal(numKillPerHour);
			
			return bigDecimalMaxMeso.multiply(bigDecimalKills);
		}
		
	}
	
	public BigDecimal minMesoPerHour(String mobMinMeso, int numKillPerHour) {
		
		if (mobMinMeso.equalsIgnoreCase("Unknown")) {
			return new BigDecimal(-1);
		} else {
			BigDecimal bigDecimalMinMeso = new BigDecimal(mobMinMeso);
			BigDecimal bigDecimalKills = new BigDecimal(numKillPerHour);
			
			return bigDecimalMinMeso.multiply(bigDecimalKills);
		}
		
	}
}
