package com.gic.notifications.listener;

import com.gic.notifications.domain.event.PaymentSucceededEvent;
import com.gic.notifications.service.NotificationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentSucceededEventListener {

    private final NotificationService notificationService;

    public PaymentSucceededEventListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @EventListener
    public void handle(PaymentSucceededEvent event) {
        notificationService.sendNotification(event);
    }
}

