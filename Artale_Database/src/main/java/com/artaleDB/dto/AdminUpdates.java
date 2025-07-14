package com.artaleDB.dto;

import java.time.LocalDateTime;

public class AdminUpdates {
	String updateText;
	LocalDateTime localDateTime;
	
	
	public AdminUpdates(String updateText, LocalDateTime localDateTime) {
		super();
		this.updateText = updateText;
		this.localDateTime = localDateTime;
	}


	public String getUpdateText() {
		return updateText;
	}


	public void setUpdateText(String updateText) {
		this.updateText = updateText;
	}


	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	
	
}
