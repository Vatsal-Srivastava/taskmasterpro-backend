package com.practice.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.taskmaster.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
