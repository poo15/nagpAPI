package com.nagarro.nagp.service;

import java.util.List;

import com.nagarro.nagp.model.User;


public interface UserLogin {

	List<User> getAllusers();
	
	int addAdmin(User user);
	
	
	Object login(User user);
	
}
