package com.nagarro.nagp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ActivityRecords")
public class ActivityRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityRecordId;
	
	@ManyToOne
	private Activity activity;
	
	@Column(nullable = false)
	private String levelId;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private double percentage;
	
	@ManyToOne
	private Applicant applicant;
	
	@Column(length= 1000)
	private String description;
	
	@Column(length = 500)
	private String documentUrl;
	
	private int attempts;
	
	private double points;
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getActivityRecordId() {
		return activityRecordId;
	}

	public void setActivityRecordId(int activityRecordId) {
		this.activityRecordId = activityRecordId;
	}

	@Column(nullable = false)
	private String startDate;
	
	
	private String doneDate;
	
	
	private String completionDate;

	public int getApplicantId() {
		return activityRecordId;
	}

	public void setApplicantId(int activityRecordId) {
		this.activityRecordId = activityRecordId;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
		

}
