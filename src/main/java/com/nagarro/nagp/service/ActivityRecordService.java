package com.nagarro.nagp.service;

import java.util.List;

import com.nagarro.nagp.model.ActivityRecord;

public interface ActivityRecordService {
	
	ActivityRecord addRecord(ActivityRecord activityRecord);
	
	ActivityRecord getActivityRecord(int applicantId, String activityId);
	
	List<ActivityRecord> getActivityRecord(int applicantId);
	
	boolean updateActivityRecord(int recordId, ActivityRecord activityRecord);
	boolean updateActivityRecordByAdmin(int recordId, ActivityRecord activityRecord);
	
}
