package com.nagarro.nagp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.nagp.model.Notification;
import com.nagarro.nagp.service.NotificationService;

@CrossOrigin("*")
@RequestMapping("/admin/notification")
@RestController
public class NotificationResource {
		
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("")
	public List <Notification> getNotification(){
		return notificationService.getUserNotifications();
	}
}
