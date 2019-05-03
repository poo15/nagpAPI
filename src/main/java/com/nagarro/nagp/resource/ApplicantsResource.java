package com.nagarro.nagp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.model.Applicant;
import com.nagarro.nagp.service.ApplicantService;

@CrossOrigin("*")
@RequestMapping("/applicant")
@RestController
public class ApplicantsResource {

	@Autowired
	private ApplicantService applicantService;
	
	@GetMapping("/admin")
	public List<Applicant> getApplicants(){
		return applicantService.getAllApplicant();
	}
	
	@GetMapping("/{id}")
	public Applicant getApplicant(@PathVariable("id") int id){
		return applicantService.getApplicant(id);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<String> saveApplicant(@RequestBody Applicant applicant){
		int id = applicantService.addApplicant(applicant);
		if(id!=0)
			return ResponseEntity.ok().body("Applicant added"+id);
		return ResponseEntity.ok().body("error");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateApplicant(@PathVariable("id") int id,@RequestBody Applicant applicant){
		if(applicantService.editApplicant(id,applicant))
			return ResponseEntity.ok().body("Applicant Updated");
		return ResponseEntity.ok().body("error");
	}
	
}
