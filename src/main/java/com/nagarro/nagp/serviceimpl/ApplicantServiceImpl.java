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
/**
 * @author pooja01
 *
 */
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
	
	private Role role = new Role();
	
	
	private User user = new User();
	
	/**
     * This method get all the applicants
     * 
     * @return List of Applicants
     * 
     */
	@Override
	public List<Applicant> getAllApplicant() {
		return applicantRepository.findAll();
	}

	
	/**
     * This method find a particular applicant
     * 
     * @param id
     * 
     * @return Applicant
     */
	@Override
	public Applicant getApplicant(int id) {
		Applicant currentApplicant = applicantRepository.find(id);
		if(currentApplicant!=null)
			return currentApplicant;
		else
			return null;
	}

	/**
     * This method add an applicant
     * 
     * @param Applicant
     * 
     */
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

	
	/**
     * This method check a batch exists or not
     * 
     * @param Id- Batch id
     * 
     * @return boolean
     * 
     */
	boolean checkBatchExists(String id){
			return batchServiceImpl.getBatch(id) !=null;
	}
	
	/**
     * This method check a level exists or not
     * 
     * @param Id- Level id
     * 
     * @return boolean
     * 
     */
	boolean checkLevelExists(String id){
		return levelServiceImpl.getLevel(id) !=null;
	}
	
	/**
     * This method edit a particular applicant
     * 
     * @param Id- applicant Id, Applicant
     * 
     * @return boolean
     * 
     */
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
