package com.nagarro.nagp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Applicant",uniqueConstraints={@UniqueConstraint(columnNames={"applicantId"})} )
public class Applicant {
	
	@Id
	private int applicantId;
	
	@OneToOne
	@JoinColumn(name="id")
	private User user;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "contactNo", nullable = false)
	private String contactNo;
	
	@ManyToOne
	private Level level;
	
	@ManyToOne
	private Batch batch;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="applicant")
	private List<ActivityRecord> applicantActivityRecords;
	
	@Column(name = "status", nullable = false)
	private String status;

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
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

	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Applicant [applicantId=" + applicantId + ", user=" + user + ", name=" + name + ", email=" + email
				+ ", contactNo=" + contactNo + ", level=" + level + ", batch=" + batch
				+", status=" + status + "]";
	}
	
	
}
