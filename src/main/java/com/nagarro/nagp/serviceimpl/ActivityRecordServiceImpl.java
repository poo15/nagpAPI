package com.nagarro.nagp.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.model.ActivityRecord;
import com.nagarro.nagp.model.ActivityStatus;
import com.nagarro.nagp.model.Notification;
import com.nagarro.nagp.repository.ActivityRecordRepository;
import com.nagarro.nagp.service.ActivityRecordService;

@Service
public class ActivityRecordServiceImpl implements ActivityRecordService{

	@Autowired
	private ActivityRecordRepository applicantRecordRepository;
	
	@Autowired
	private NotificationServiceImpl notificationServiceImpl;
	
	@Override
	public ActivityRecord addRecord(ActivityRecord activityRecord) {
		ActivityRecord presentRecord = applicantRecordRepository.findRecord(activityRecord.getApplicantId(), activityRecord.getActivity().getId());  
		if( presentRecord != null ) {
			updateActivityRecord( presentRecord.getActivityRecordId(), activityRecord);
		}
		activityRecord.setAttempts(1);
			activityRecord.setStartDate(dateFormat());
		return  applicantRecordRepository.save(activityRecord); 
	}

	@Override
	public ActivityRecord getActivityRecord(int applicantId, String activityId) {
		return applicantRecordRepository.findRecord(applicantId, activityId);
	}

	@Override
	public boolean updateActivityRecord(int recordId, ActivityRecord activityRecord) {
			if(activityRecord.getAttempts()+1 <= activityRecord.getActivity().getMaxQualificationPoints()) {
			if(checkValidStatus(activityRecord.getStatus())) {
				if(activityRecord.getStatus().equals("DONE")) {
					activityRecord.setDoneDate(dateFormat());
					generateNotification(activityRecord);
					activityRecord.setStatus("REVIEW PENDING");
				}
				applicantRecordRepository.update(recordId,activityRecord.getStatus(), activityRecord.getDescription(),
						activityRecord.getCompletionDate(),activityRecord.getDoneDate());
				return true;
			}
		}
		 return false;
		 
	}
	
	
	private boolean checkValidStatus(String recordStatus) {
		for(ActivityStatus status: ActivityStatus.values()) {
			System.out.println(recordStatus+" is compared with enum "+ status.name());
			if((recordStatus.toUpperCase()).contains(status.name())) {
				
				return true;
			}
		}
		return false;
	}

	private void generateNotification(ActivityRecord activityRecord) {
		Notification notification = new Notification();
		notification.setMessage(activityRecord.getApplicant().getName()+" has marked the "+activityRecord.getActivity().getName()+" as DONE");
		notification.setReadStatus(false);
		notification.setDate(dateFormat());
		notification.setRecordId(activityRecord);
		notificationServiceImpl.saveNotification(notification);
	}
	
	private String dateFormat() {
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		return (format.format(new Date()));	
	}

	@Override
	public List<ActivityRecord> getActivityRecord(int applicantId) {
		
		return applicantRecordRepository.findApplicantAllRecord(applicantId);
	}

	@Override
	public boolean updateActivityRecordByAdmin(int recordId, ActivityRecord activityRecord) {
		System.out.println("set status:- "+ activityRecord.getStatus());
		if(checkValidStatus(activityRecord.getStatus())) {
			if(activityRecord.getStatus().equals("COMPLETED")) {
				activityRecord.setCompletionDate(dateFormat());
				activityRecord.setStatus("COMPLETED");
				activityRecord.setPercentage(activityRecord.getPercentage());
				activityRecord.setPoints((activityRecord.getPercentage()/100)*activityRecord.getActivity().getPoints());
			}else if(activityRecord.getStatus().equals("REVIEW FAILED")) {
				activityRecord.setStatus("REVIEW FAILED");
			}
			applicantRecordRepository.updateScore(recordId, activityRecord.getStatus(), activityRecord.getPercentage(),
												activityRecord.getPoints(), activityRecord.getCompletionDate());
			return true;
		}
		return false;
	}
}
