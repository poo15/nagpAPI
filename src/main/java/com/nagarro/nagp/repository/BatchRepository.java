package com.nagarro.nagp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagp.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer>{

	@Query(" from Batch where id=:id")
	public Batch find(@Param("id") String id);
	
	@Query(" DELETE from Batch where id=:id")
	public void delete(@Param("id") String id);
}
