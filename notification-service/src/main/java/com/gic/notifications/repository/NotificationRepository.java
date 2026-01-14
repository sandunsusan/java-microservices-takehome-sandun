package com.gic.notifications.repository;

import com.gic.notifications.domain.Notification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class NotificationRepository {

    private final List<Notification> notifications = new CopyOnWriteArrayList<>();

    public void save(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> findAll() {
        return List.copyOf(notifications);
    }
}

