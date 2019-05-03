package com.nagarro.nagp.service;

import java.util.List;

import com.nagarro.nagp.model.Applicant;

public interface ApplicantService {

	List<Applicant> getAllApplicant();
	
	Applicant getApplicant(int id);
	
	int addApplicant(Applicant applicant);
	
	boolean editApplicant(int id, Applicant applicant);
}
