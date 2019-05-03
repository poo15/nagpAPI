package com.nagarro.nagp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagp.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{
	
	@Query("FROM Notification where read_status=:status")
	List<Notification> getAllNotifications(@Param("status") int status);

}
