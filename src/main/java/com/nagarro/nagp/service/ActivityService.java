package com.nagarro.nagp.service;

import java.util.List;

import com.nagarro.nagp.model.Activity;

public interface ActivityService {
	
	List<Activity> getActivities();
	
	Activity getActivity(String id);
	
	int addActivity(Activity activity);
	
	boolean editActivity(String id, Activity activity);
	
	List<Activity> getBatchLevelActivities(String LevelId, String batchId);
	
}
