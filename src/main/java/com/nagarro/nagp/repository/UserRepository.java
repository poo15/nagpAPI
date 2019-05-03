package com.nagarro.nagp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagp.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByname(String username);
	
	List<User> findAll();
	
	@Query(" from User where name=:name AND password=:password")
	public User find(@Param("name") String name, @Param("password") String password);
}
