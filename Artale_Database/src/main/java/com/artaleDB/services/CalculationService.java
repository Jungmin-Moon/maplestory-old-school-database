package com.artaleDB.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class CalculationService {

	
	public BigDecimal expPerHour(int mobExp, int numKillPerHour) {
		
		return new BigDecimal(mobExp * numKillPerHour);
		
	}
	
}
