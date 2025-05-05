package com.artaleDB.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "database_updates")
public class DatabaseUpdates {
	@Id
	private long updateID;
	
	private String updateText;
	
	private LocalDateTime postedDate;

	public long getUpdateID() {
		return updateID;
	}

	public void setUpdateID(long updateID) {
		this.updateID = updateID;
	}

	public String getUpdateText() {
		return updateText;
	}

	public void setUpdateText(String updateText) {
		this.updateText = updateText;
	}

	public LocalDateTime getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDateTime postedDate) {
		this.postedDate = postedDate;
	}
	
	
}
