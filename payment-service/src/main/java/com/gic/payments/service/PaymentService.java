package com.gic.payments.service;

import com.gic.payments.domain.Payment;
import com.gic.payments.domain.event.OrderCreatedEvent;
import com.gic.payments.domain.event.PaymentSucceededEvent;
import com.gic.payments.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    private final PaymentRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    public PaymentService(PaymentRepository repository,
                          ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public void processPayment(OrderCreatedEvent event) {

        log.info("Processing payment for order {}", event.getOrderId());

        String paymentId = UUID.randomUUID().toString();

        Payment payment = new Payment(
                paymentId,
                event.getOrderId(),
                event.getAmount(),
                Instant.now()
        );

        repository.save(payment);

        eventPublisher.publishEvent(
                new PaymentSucceededEvent(
                        event.getOrderId(),
                        paymentId,
                        event.getAmount(),
                        payment.getTimestamp()
                )
        );

        log.info("Payment succeeded for order {}", event.getOrderId());
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }
}
