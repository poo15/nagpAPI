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
	
	/**
     * This method handle the get request to get all the activities
     * 
     * 
     * 
     * @return List of Activities
     * 
     */
	@GetMapping("/admin")
	public List<Activity> getActivities(){
		return activityService.getActivities();
	}
	
	/**
     * This method handle the get request to find an activity
     * 
     * @param id- Activity id
     * 
     * @return Activity
     * 
     */
	@GetMapping("/admin/{id}")
	public Activity getActivity(@PathVariable("id") String id){
		return activityService.getActivity(id);
	}
	
	/**
     * This method  handle the post request to adds an activity
     * 
     * @param Activity 
     * 
     * @return Integer- Id of the activity
     * 
     */
	@PostMapping("/admin")
	public ResponseEntity<String> saveActivity(@RequestBody Activity activity){
		int id = activityService.addActivity(activity);
		if(id!=0)
			return ResponseEntity.ok().body("Activity added ");
		return ResponseEntity.ok().body("error");
	}
	
	/**
     * This method handle the Put request to edit an activity
     * 
     * @param Id- Activity id, Activity object
     * 
     * @return boolean
     * 
     */
	@PutMapping("/admin/{id}")
	public ResponseEntity<String> updateActivity(@PathVariable("id") String id,@RequestBody Activity activity){
		if(activityService.editActivity(id, activity))
			return ResponseEntity.ok().body("Activity Updated");
		return ResponseEntity.ok().body("Activity Can't Updated");
	}
	
	/**
     * This method handle the get request to find all the activity of level and batch 
     * 
     * @param Id- Level id, Id- Batch id
     * 
     * @return List of Activities
     * 
     */
	@GetMapping("/{levelId}/{batchId}")
	public List<Activity> getBatchLevelActivity(@PathVariable("levelId") String levelId, 
												@PathVariable("batchId") String batchId){
		return activityService.getBatchLevelActivities(levelId, batchId);
	}
	
}
