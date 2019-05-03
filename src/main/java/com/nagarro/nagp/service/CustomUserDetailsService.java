package com.nagarro.nagp.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.model.CustomUserDetails;
import com.nagarro.nagp.model.User;
import com.nagarro.nagp.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("In CustomUserDetailsService");
		Optional<User> optional = 	userRepository.findByname(username);
		optional.orElseThrow( () -> new UsernameNotFoundException("Username not found"));
		
		return 	optional
		.map(CustomUserDetails::new).get();	
	}

}

