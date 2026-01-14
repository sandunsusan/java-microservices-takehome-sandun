package com.gic.notifications.service;

import com.gic.notifications.domain.Notification;
import com.gic.notifications.domain.event.PaymentSucceededEvent;
import com.gic.notifications.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {

    private static final Logger log =
            LoggerFactory.getLogger(NotificationService.class);

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void sendNotification(PaymentSucceededEvent event) {

        String message = String.format(
                "Payment successful for order %s (paymentId=%s, amount=%s)",
                event.getOrderId(),
                event.getPaymentId(),
                event.getAmount()
        );

        log.info("Sending notification: {}", message);

        Notification notification = new Notification(
                UUID.randomUUID().toString(),
                message,
                Instant.now()
        );

        repository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }
}
