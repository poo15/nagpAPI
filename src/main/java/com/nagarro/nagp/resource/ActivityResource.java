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

import com.nagarro.nagp.model.Activity;
import com.nagarro.nagp.service.ActivityService;

@CrossOrigin("*")
@RequestMapping("/activity")
@RestController
public class ActivityResource {
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/admin")
	public List<Activity> getActivities(){
		return activityService.getActivities();
	}
	
	@GetMapping("/admin/{id}")
	public Activity getActivity(@PathVariable("id") String id){
		System.out.println("In get activity "+activityService.getActivity(id));
		return activityService.getActivity(id);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<String> saveActivity(@RequestBody Activity activity){
		System.out.println(activity);
		int id = activityService.addActivity(activity);
		if(id!=0)
			return ResponseEntity.ok().body("Activity added ");
		return ResponseEntity.ok().body("error");
	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<String> updateActivity(@PathVariable("id") String id,@RequestBody Activity activity){
		System.out.println("Applicant to be updated:- "+activity);
		if(activityService.editActivity(id, activity))
			return ResponseEntity.ok().body("Activity Updated");
		return ResponseEntity.ok().body("Activity Can't Updated");
	}
	
	@GetMapping("/{levelId}/{batchId}")
	public List<Activity> getBatchLevelActivity(@PathVariable("levelId") String levelId, 
												@PathVariable("batchId") String batchId){
		System.out.println("In get batch level act:- "+levelId+" "+batchId);
		return activityService.getBatchLevelActivities(levelId, batchId);
	}
	
}
