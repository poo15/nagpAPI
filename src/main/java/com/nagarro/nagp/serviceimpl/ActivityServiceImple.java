package com.nagarro.nagp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Activity;
import com.nagarro.nagp.repository.ActivityRepository;
import com.nagarro.nagp.service.ActivityService;

@Service
public class ActivityServiceImple implements ActivityService{

	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private BatchServiceImpl batchServiceImpl;
	
	@Autowired
	private LevelServiceImpl levelServiceImpl;
	
	@Override
	public List<Activity> getActivities() {
		
		return activityRepository.findAll();
	}

	@Override
	public Activity getActivity(String id) {
		return activityRepository.find(id);
	}

	@Override
	public int addActivity(Activity activity) {
		int count = activityRepository.findAll().size();
		if(activity.getId() == null || activity.getId().equals("")) {
			
			activity.setId(Constants.ACTIVITY+"_"+count);
			
		}
		return saveActivity(activity) ;
	}
	
	private int saveActivity(Activity activity) {
		if(checkBatchExists(activity.getBatch().getId()) && checkLevelExists(activity.getLevel().getId())){
			activityRepository.save(activity);
			return 1;
		}
		return 0;
	}

	boolean checkBatchExists(String id){
		return batchServiceImpl.getBatch(id) !=null;
	}
	
	boolean checkLevelExists(String id){
		return levelServiceImpl.getLevel(id) !=null;
	}
	
	
	@Override
	public boolean editActivity(String id, Activity activity) {
		System.out.println("existing activity:- "+activity.getName());
		Activity oldActivity = activityRepository.find(id);
			if(oldActivity != null) {
				activity.setLevel(oldActivity.getLevel());
				activity.setBatch(oldActivity.getBatch());
				activity.setId(id);
				activityRepository.save(activity);
				return true;
			}
		return false;
	}

	@Override
	public List<Activity> getBatchLevelActivities(String levelId, String batchId) {
		System.out.println("In get batch level act service:- "+levelId+" "+batchId);
		return activityRepository.findByLevelBatch(levelId, batchId);
	}

}
