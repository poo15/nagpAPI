package com.nagarro.nagp.model;

public enum ActivityStatus {
	PLANNED("PLANNED"),
	PROGRESS("PROGRESS"),
	DONE("DONE"),
	COMPLETED("COMPLETED"),
	PENDING("REVIEW PENDING"),
	FAILED("REVIEW FAILED");
	
	
	
	private String status = null;
	ActivityStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
