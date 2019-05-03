package com.nagarro.nagp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.model.Notification;
import com.nagarro.nagp.repository.NotificationRepository;
import com.nagarro.nagp.service.NotificationService;

/**
 * @author pooja01
 *
 */
@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	/**
     * This method save a notificantion when an applicant change the status done 
     * 
     * @param Notification
     * 
     * @return Integer, id of the notification
     */
	@Override
	public int saveNotification(Notification notification) {
		
		return notificationRepository.save(notification).getNotificationId();
	}

	/**
     * This method get all the notifications for the admin
     * 
     */
	@Override
	public List	<Notification> getUserNotifications() {
		
		return notificationRepository.getAllNotifications(0);
	}

}
