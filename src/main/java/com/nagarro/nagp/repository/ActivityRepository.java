package com.nagarro.nagp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagp.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, String>{
	@Query(" from Activity where id=:id")
	public Activity find(@Param("id") String id);
	
	@Modifying
	@Transactional
	@Query(" DELETE from Activity where id=:id")
	public void delete(@Param("id") String id);
	
	@Query(" from Activity where level_id=:levelId and batch_id=:batchId")
	public List<Activity> findByLevelBatch(@Param("levelId") String levelId, @Param("batchId") String batchId);
	

}
