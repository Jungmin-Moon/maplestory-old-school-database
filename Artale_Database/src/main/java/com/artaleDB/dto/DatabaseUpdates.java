package com.artaleDB.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "database_updates")
public class DatabaseUpdates {
	@Id
	private long updateID;
	
	private String updateText;
	
	private LocalDate postedDate;

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

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}
	
	
}
