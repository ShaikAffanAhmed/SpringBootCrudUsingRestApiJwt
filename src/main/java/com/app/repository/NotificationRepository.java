package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
