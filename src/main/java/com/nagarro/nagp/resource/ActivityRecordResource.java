package com.nagarro.nagp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.model.ActivityRecord;
import com.nagarro.nagp.serviceimpl.ActivityRecordServiceImpl;

@CrossOrigin("*")
@RequestMapping("/activitiesRecord")
@RestController	
public class ActivityRecordResource{
	
	@Autowired
	private ActivityRecordServiceImpl activityRecordServiceImpl;
	
	@GetMapping("/applicant/{applicantId}/{activityId}")
	public ActivityRecord getActivityRecords(@PathVariable("applicantId") int applicantId, 
														@PathVariable("activityId") String activityId){
		return activityRecordServiceImpl.getActivityRecord(applicantId, activityId);
	}
	
	@GetMapping("/applicant/{applicantId}")
	public List<ActivityRecord> getApplicantAllActivityRecords(@PathVariable("applicantId") int applicantId){
		return activityRecordServiceImpl.getActivityRecord(applicantId);
	}
	
	
	
	@PutMapping("/applicant/{recordId}")
	public String updateActivityRecord(@PathVariable("recordId") int recordId, @RequestBody ActivityRecord activityRecord) 
	{

		if(activityRecordServiceImpl.updateActivityRecord(recordId, activityRecord))
			return "done";
		return "error";
	}
	
	@PutMapping("/admin/{recordId}")
	public String updateActivityRecordByAdmin(@PathVariable("recordId") int recordId, @RequestBody ActivityRecord activityRecord) 
	{

		if(activityRecordServiceImpl.updateActivityRecordByAdmin(recordId, activityRecord))
			return "done";
		return "error";
	}
	
	@PostMapping("")
	public ActivityRecord  addRecord(@RequestBody ActivityRecord activityRecord) {
		return activityRecordServiceImpl.addRecord(activityRecord);
	}
}
