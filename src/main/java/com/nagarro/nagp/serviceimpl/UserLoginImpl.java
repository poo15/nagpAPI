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

@Service
public class UserLoginImpl implements UserLogin{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;

	
	private Role role = new Role();
	
	
	private User user = new User();
	@Override
	public List<User> getAllusers() {
		
		return userRepository.findAll();
	}

	@Override
	public int addAdmin(User user) {
		role.setRole("ADMIN");
		Set<Role> s = new HashSet<Role>();
		s.add(role);
		user.setRoles(s);
		return userRepository.save(user).getId();
	}

	

	@Override
	
	public Object login(User user) {
		User validUser = userRepository.find(user.getName(),user.getPassword());
		if(validUser != null && validUser.getRoles().iterator().next().getRole()
								.equalsIgnoreCase(Constants.APPLICANT)) {
				return applicantRepository.find(Integer.parseInt(user.getName()));
		}
		return validUser;
	}
	
	
}
