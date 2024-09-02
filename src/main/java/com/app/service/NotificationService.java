package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Company;
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
	public Notification update(Integer id, Notification updatedNotification) {
		if (notificationRepository.existsById(id)) {
			updatedNotification.setSeqid(id);
			return notificationRepository.save(updatedNotification);
		} else {
			throw new RuntimeException("Notification not found with id " + id);
		}
	}

	// delete
	public String deletebyId(Integer id) {
		Optional<Notification> details = this.notificationRepository.findById(id);

		if (details.isEmpty()) {
			return "This ID doesn't exist";
		}

		this.notificationRepository.deleteById(id);
		return "Deleted successfully";
	}
}
