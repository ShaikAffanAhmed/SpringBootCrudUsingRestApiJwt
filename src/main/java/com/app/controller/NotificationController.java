package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Notification;
import com.app.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping("/create")
	public Notification createNotification(@RequestBody Notification notification) {
		return notificationService.save(notification);
	}

	@GetMapping("/fetchAll")
	public List<Notification> getAllNotifications() {
		return notificationService.findAll();
	}

	@PutMapping("/update/{id}")
	public Notification updateNotification(@PathVariable Integer id, @RequestBody Notification notification) {
		notification.setSeqid(id);
		return notificationService.save(notification);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteNotification(@PathVariable Integer id) {
		notificationService.deletebyId(id);
	}

}
