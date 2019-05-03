package com.nagarro.nagp.service;

import java.util.List;

import com.nagarro.nagp.model.Notification;

public interface NotificationService {
	
	int saveNotification(Notification notification);
	
	List <Notification> getUserNotifications();

}
