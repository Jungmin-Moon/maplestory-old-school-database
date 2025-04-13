package com.artaleDB.services;

import java.math.BigDecimal;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

@Component
public class CalculationService {

	
	public BigDecimal expPerHour(int mobExp, int numKillPerHour) {
		
		return new BigDecimal(mobExp * numKillPerHour);
		
	}
	
	
	public BigDecimal maxMesoPerHour(long mobMaxMeso, int numKillPerHour) {
		
		if (mobMaxMeso == 0) {
			return new BigDecimal(0);
		} else {
			BigDecimal bigDecimalMaxMeso = new BigDecimal(mobMaxMeso);
			BigDecimal bigDecimalKills = new BigDecimal(numKillPerHour);
			
			return bigDecimalMaxMeso.multiply(bigDecimalKills);
		}
		
	}
	
	public BigDecimal minMesoPerHour(long mobMinMeso, int numKillPerHour) {
		
		if (mobMinMeso == 0) {
			return new BigDecimal(0);
		} else {
			BigDecimal bigDecimalMinMeso = new BigDecimal(mobMinMeso);
			BigDecimal bigDecimalKills = new BigDecimal(numKillPerHour);
			
			return bigDecimalMinMeso.multiply(bigDecimalKills);
		}
		
	}
	
	public <T> long getCount(Iterable<T> list) {
		return StreamSupport.stream(list.spliterator(), false).count();
	}
}
