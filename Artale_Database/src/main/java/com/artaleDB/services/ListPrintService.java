package com.artaleDB.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.artaleDB.entities.Mob;

@Component
public class ListPrintService {
	
	
	public String printListWithMobNameAndAccuracy(List<Mob> mobList) {
		
		StringBuilder onlyNameAccuracy = new StringBuilder();
		onlyNameAccuracy.append("This is the list of mobs who you can hit with your given accuracy:" + "/n");
		
		for (Mob mob : mobList) {
			
		}
		
		return onlyNameAccuracy.toString();
	}
}
