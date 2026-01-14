package com.gic.payments.listener;

import com.gic.payments.domain.event.OrderCreatedEvent;
import com.gic.payments.service.PaymentService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedEventListener {

    private final PaymentService paymentService;

    public OrderCreatedEventListener(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @EventListener
    public void handle(OrderCreatedEvent event) {
        paymentService.processPayment(event);
    }
}

