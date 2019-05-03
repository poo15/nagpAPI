package com.nagarro.nagp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagp.model.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{
	
	@Query(" from Applicant where applicant_id=:applicant_id")
	public Applicant find(@Param("applicant_id") int applicantId);
	
	@Modifying
	@Transactional
	@Query( " UPDATE Applicant set name=:name, email=:email, contact_no=:contact, status=:status where applicant_id=:id")
	public void update(@Param("id") int id,@Param("name") String name,@Param("email") String email,@Param("contact") String contact,
							@Param("status") String status);

	
}
