package com.nagarro.nagp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Level")
public class Level {
	@Id
	@Column(name = "id")
	private String id;

	@Column(nullable = false)
	private int number;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false, length = 1000)
	private String description;
	
	@Column(nullable = false)
	private int qualificationPoint;

//	@OneToMany(fetch=FetchType.LAZY, mappedBy="level", cascade = CascadeType.PERSIST, orphanRemoval = true)
//	private List<Activity> activity;
//	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="level", cascade = CascadeType.PERSIST, orphanRemoval = true)
//	private List<Applicant> applicant;
	
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void setApplicant(List<Applicant> applicant) {
		this.applicant = applicant;
	}

	public void setActivity(List<Activity> activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Level [id=" + id + ", number=" + number + ", name=" + name + ", description=" + description
				+ ", qualificationPoint=" + qualificationPoint + "" +  "]";
	}

		
}
