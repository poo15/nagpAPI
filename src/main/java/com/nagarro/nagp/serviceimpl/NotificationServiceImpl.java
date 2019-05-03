package com.nagarro.nagp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagp.model.Notification;
import com.nagarro.nagp.repository.NotificationRepository;
import com.nagarro.nagp.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	@Override
	public int saveNotification(Notification notification) {
		
		return notificationRepository.save(notification).getNotificationId();
	}

	@Override
	public List	<Notification> getUserNotifications() {
		
		return notificationRepository.getAllNotifications(0);
	}

}
