package com.nagarro.nagp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagp.model.Level;

public interface LevelRepository extends JpaRepository<Level, Integer> {

	
	@Query(" from Level where id=:id")
	public Level find(@Param("id") String id);
	
	@Query(" from Level where number=:number")
	public Optional<Level> findLevel(@Param("number") int number);
}
