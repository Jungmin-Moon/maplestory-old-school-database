package com.artaleDB.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.artaleDB.entities.Mob;

@Component
public class ListPrintService {
	
	
	public String printListWithMobNameAndAccuracy(List<Mob> mobList) {
		
		StringBuilder onlyNameAccuracy = new StringBuilder();
		//onlyNameAccuracy.append("This is the list of mobs who you can hit with your given accuracy:" + "\n");
		
		for (Mob mob : mobList) {
			onlyNameAccuracy.append("Mob Name: " + mob.getMobName() + "\nMob Accuracy: " + mob.getMobNeededAccuracy() + "\n");
		}
		
		return onlyNameAccuracy.toString();
	}
	
	public String printListWithMobNameAndMaxMeso(List<Mob> mobList) {
		
		StringBuilder onlyNameMaxMeso = new StringBuilder();
		//onlyNameMaxMeso.append("");
		
		for (Mob mob : mobList) {
			onlyNameMaxMeso.append("Mob Name: " + mob.getMobName() + "\nMob Max Meso: " + mob.getMobMaxMeso() + "\n");
		}
		
		return onlyNameMaxMeso.toString();
	}
}
