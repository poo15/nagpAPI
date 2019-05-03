package com.nagarro.nagp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Batch",uniqueConstraints={@UniqueConstraint(columnNames={})})
public class Batch {
	@Id
	@Column(name="id", length = 100)
	private String id;
	
	@Column(nullable = false)
	private int year;
	
	@Column(nullable = false)
	private String technology;
	
	@Column(nullable = false,length = 1000)
	private String description;
	
	@Column(nullable = false)
	private int qualificationPoint;

	@Column(nullable = false)
	private String date;
	
	@OneToMany( mappedBy="level")
	private List<Applicant> applicant;
	
	@OneToMany( mappedBy="level")
	private List<Activity> activity;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQualificationPoint() {
		return qualificationPoint;
	}

	public void setQualificationPoint(int qualificationPoint) {
		this.qualificationPoint = qualificationPoint;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

	public void setApplicant(List<Applicant> applicant) {
		this.applicant = applicant;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", year=" + year + ", technology=" + technology + ", description=" + description
				+ ", qualificationPoint=" + qualificationPoint + ", date=" + date + "" +  "]";
	}

	
}
