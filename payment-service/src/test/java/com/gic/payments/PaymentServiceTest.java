package com.gic.payments;

import com.gic.payments.domain.Payment;
import com.gic.payments.domain.event.OrderCreatedEvent;
import com.gic.payments.domain.event.PaymentSucceededEvent;
import com.gic.payments.repository.PaymentRepository;
import com.gic.payments.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    void shouldProcessPaymentAndPublishEvent() {
        // given
        OrderCreatedEvent event = new OrderCreatedEvent(
                "order-123",
                BigDecimal.valueOf(100.00),
                "user@example.com"
        );

        // when
        paymentService.processPayment(event);

        // then
        verify(paymentRepository).save(any(Payment.class));
        verify(eventPublisher).publishEvent(any(PaymentSucceededEvent.class));
    }
}

