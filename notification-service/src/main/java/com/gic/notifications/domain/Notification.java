package com.gic.notifications.domain;

import java.time.Instant;

public class Notification {

    private final String notificationId;
    private final String message;
    private final Instant timestamp;

    public Notification(String notificationId, String message, Instant timestamp) {
        this.notificationId = notificationId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
