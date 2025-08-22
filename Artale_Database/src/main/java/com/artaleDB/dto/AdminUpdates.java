package com.artaleDB.dto;

import java.time.LocalDateTime;

public class AdminUpdates {
	String updateText;
	String localDateTime;
	
	
	public AdminUpdates(String updateText, String localDateTime) {
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


	public String getLocalDateTime() {
		return localDateTime;
	}


	public void setLocalDateTime(String localDateTime) {
		this.localDateTime = localDateTime;
	}
	
	
}
