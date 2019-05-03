package com.nagarro.nagp.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Applicant;
import com.nagarro.nagp.model.Role;
import com.nagarro.nagp.model.User;
import com.nagarro.nagp.repository.ApplicantRepository;
import com.nagarro.nagp.repository.UserRepository;
import com.nagarro.nagp.service.ApplicantService;
@Service
public class ApplicantServiceImpl implements ApplicantService{

	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BatchServiceImpl batchServiceImpl;
	
	@Autowired
	private LevelServiceImpl levelServiceImpl;
	
	@Autowired
	private ActivityRecordServiceImpl recordsServiceImpl;
	private Role role = new Role();
	
	
	private User user = new User();
	
	
	@Override
	public List<Applicant> getAllApplicant() {
		return applicantRepository.findAll();
	}

	@Override
	public Applicant getApplicant(int id) {
		Applicant currentApplicant = applicantRepository.find(id);
		if(currentApplicant!=null)
			return currentApplicant;
		else
			return null;
	}

	@Override
	public int addApplicant(Applicant applicant) {
		if(checkBatchExists(applicant.getBatch().getId())){
			role.setRole("APPLICANT");
			Set<Role> s = new HashSet<>();
			s.add(role);
			user.setName(Integer.toString(applicant.getApplicantId()));
			user.setPassword(applicant.getContactNo());
			user.setRoles(s);
			applicant.setUser(user);
			applicant.setLevel(levelServiceImpl.findIntialLevel());
			applicant.setStatus(Constants.ASPIRING);
			userRepository.save(user);
			return applicantRepository.save(applicant).getApplicantId();
		}
		return 0;
		
	}

	
	
	boolean checkBatchExists(String id){
			return batchServiceImpl.getBatch(id) !=null;
	}
	
	boolean checkLevelExists(String id){
		return levelServiceImpl.getLevel(id) !=null;
	}
	
	@Override
	public boolean editApplicant(int id, Applicant applicant) {
		Applicant currentAplicant = applicantRepository.find(id);
			if(currentAplicant != null) {
				applicantRepository.update(id,applicant.getName(),applicant.getEmail(), 
											applicant.getContactNo(), applicant.getStatus());
				return true;
			}
		return false;
	}

}
