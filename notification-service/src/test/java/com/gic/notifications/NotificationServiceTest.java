package com.gic.notifications;

import com.gic.notifications.domain.Notification;
import com.gic.notifications.domain.event.PaymentSucceededEvent;
import com.gic.notifications.repository.NotificationRepository;
import com.gic.notifications.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificationServiceTest {

    @Mock
    private NotificationRepository repository;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void shouldCreateNotificationOnPaymentSuccess() {
        // given
        PaymentSucceededEvent event = new PaymentSucceededEvent(
                "order-1",
                "payment-1",
                BigDecimal.valueOf(20),
                Instant.now()
        );

        // when
        notificationService.sendNotification(event);

        // then
        verify(repository).save(any(Notification.class));
    }
}

