package com.nagarro.nagp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagp.model.ActivityRecord;

public interface ActivityRecordRepository extends JpaRepository<ActivityRecord, Integer> {

	@Query(" From ActivityRecord where applicant_applicant_id=:applicantId and activity_id=:activityId")
	public ActivityRecord findRecord(@Param("applicantId")int applicantId,@Param("activityId") String activityId);
	
	@Query(" From ActivityRecord where applicant_applicant_id=:applicantId")
	public List<ActivityRecord> findApplicantAllRecord(@Param("applicantId")int applicantId);
	
	
	@Modifying
	@Transactional
	@Query( " UPDATE ActivityRecord set status=:status, description=:description, completion_Date=:completionDate,"
			+ " done_date=:doneDate where activity_record_id=:id")
	public void update(@Param("id") int id, @Param("status") String status,@Param("description") String description,
						@Param("completionDate") String competionDate,@Param("doneDate") String doneDate);
	
	@Modifying
	@Transactional
	@Query( " UPDATE ActivityRecord set status=:status, percentage=:percentage,points=:points, completion_Date=:completionDate"
			+ "  where activity_record_id=:id")
	public void updateScore(@Param("id") int id, @Param("status") String status,@Param("percentage") double percentage, @Param("points") double points,
						@Param("completionDate") String competionDate);

	
}
