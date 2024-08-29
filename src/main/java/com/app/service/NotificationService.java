package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Notification;
import com.app.repository.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;

	// create
	public Notification save(Notification notification) {
		return notificationRepository.save(notification);
	}

	// fetch
	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}

	// update
	public Notification update(Integer id, Notification notification) {
		if (notificationRepository.existsById(id)) {
			notification.setSeqid(id);
			return notificationRepository.save(notification);
		} else {
			throw new RuntimeException("Notification not found with id " + id);
		}
	}

	// delete
	public void deletebyId(Integer id) {
		notificationRepository.deleteById(id);
	}
}
