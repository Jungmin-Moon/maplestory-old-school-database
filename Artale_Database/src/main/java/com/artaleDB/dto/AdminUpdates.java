package com.artaleDB.dto;

import java.time.LocalDateTime;

public record AdminUpdates(
		String updateText,
		LocalDateTime localDateTime
		
		)
{}
