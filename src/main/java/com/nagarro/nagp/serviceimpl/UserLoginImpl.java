	package com.nagarro.nagp.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Role;
import com.nagarro.nagp.model.User;
import com.nagarro.nagp.repository.ApplicantRepository;
import com.nagarro.nagp.repository.UserRepository;
import com.nagarro.nagp.service.UserLogin;

/**
 * @author pooja01
 *
 */
@Service
public class UserLoginImpl implements UserLogin{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;

	
	private Role role = new Role();
	
	/**
     * This method find all the users 
     * 
     * 
     */
	@Override
	public List<User> getAllusers() {
		
		return userRepository.findAll();
	}

	/**
     * This method adds an admin to the system
     * 
     * @param User
     * 
     */
	@Override
	public int addAdmin(User user) {
		role.setRole("ADMIN");
		Set<Role> s = new HashSet<Role>();
		s.add(role);
		user.setRoles(s);
		return userRepository.save(user).getId();
	}

	/**
     * This method adds an applicant
     * 
     * @param User
     * 
     */

	@Override
	
	public Object login(User applicant) {
		User validUser = userRepository.find(applicant.getName(),applicant.getPassword());
		if(validUser != null && validUser.getRoles().iterator().next().getRole()
								.equalsIgnoreCase(Constants.APPLICANT)) {
				return applicantRepository.find(Integer.parseInt(applicant.getName()));
		}
		return validUser;
	}
	
	
}
