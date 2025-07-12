package com.artaleDB.dto;

public record UserSearchQueryBoss(
		
		String bossName,
		int bossLevel,
		int bossHP,
		int bossMinRepsawn,
		int bossMaxRespawn,
		String bossLocationOne,
		String bossLocationTwo
		
		
		) {

}
