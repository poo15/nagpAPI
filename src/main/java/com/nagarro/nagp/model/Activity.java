package com.nagarro.nagp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="Activity",uniqueConstraints={@UniqueConstraint(columnNames={"name","levelId","batchId"})})
public class Activity {
	
	@Id
	@Column(length = 100)
	private String id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(nullable = false,length = 1000)
	private String description;
	
	@Column(nullable = false)
	private int points;
	
	@Column(nullable = false)
	private int maxQualificationPoints;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "levelId",referencedColumnName="id",nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	private Level level;
	
	@ManyToOne()
	@JoinColumn(name = "batchId",referencedColumnName="id",nullable = false)
	private Batch batch;
	
	private boolean optional;
	
	public boolean getOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	@OneToMany(fetch=FetchType.LAZY,mappedBy="activity")
	private List<ActivityRecord> applicantActivityRecord;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMaxQualificationPoints() {
		return maxQualificationPoints;
	}

	public void setMaxQualificationPoints(int maxQualificationPoints) {
		this.maxQualificationPoints = maxQualificationPoints;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", description=" + description + ", points=" + points
				+ ", maxQualificationPoints=" + maxQualificationPoints + ", level=" + level + ", batch=" + batch
				+ ", applicantActivityRecord=" + applicantActivityRecord + "]";
	}

	
}
