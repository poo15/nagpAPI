package com.nagarro.nagp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.constants.Constants;
import com.nagarro.nagp.model.Activity;
import com.nagarro.nagp.repository.ActivityRepository;
import com.nagarro.nagp.service.ActivityService;

/**
 * @author pooja01
 *
 */
@Service
public class ActivityServiceImple implements ActivityService{

	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private BatchServiceImpl batchServiceImpl;
	
	@Autowired
	private LevelServiceImpl levelServiceImpl;
	
	/**
     * This method get all the activities
     * 
     * 
     * 
     * @return List of Activities
     * 
     */
	@Override
	public List<Activity> getActivities() {
		
		return activityRepository.findAll();
	}

	/**
     * This method find an activity
     * 
     * @param id- Activity id
     * 
     * @return Activity
     * 
     */
	@Override
	public Activity getActivity(String id) {
		return activityRepository.find(id);
	}

	/**
     * This method adds an activity
     * 
     * @param Activity 
     * 
     * @return Integer- Id of the activity
     * 
     */
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


	/**
     * This method check a batch exists or not
     * 
     * @param Id- Batch id
     * 
     * @return boolean
     * 
     */
	boolean checkBatchExists(String id){
		return batchServiceImpl.getBatch(id) !=null;
	}
	/**
     * This method check a level exists or not
     * 
     * @param Id- Level id
     * 
     * @return boolean
     * 
     */
	boolean checkLevelExists(String id){
		return levelServiceImpl.getLevel(id) !=null;
	}
	
	
	/**
     * This method edit an activity
     * 
     * @param Id- Activity id, Activity object
     * 
     * @return boolean
     * 
     */
	@Override
	public boolean editActivity(String id, Activity activity) {
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

	/**
     * This method find all the activity of level and batch 
     * 
     * @param Id- Level id, Id- Batch id
     * 
     * @return List of Activities
     * 
     */
	@Override
	public List<Activity> getBatchLevelActivities(String levelId, String batchId) {
		return activityRepository.findByLevelBatch(levelId, batchId);
	}

}
