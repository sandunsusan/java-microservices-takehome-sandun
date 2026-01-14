package com.gic.notifications.domain.event;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentSucceededEvent {

    private final String orderId;
    private final String paymentId;
    private final BigDecimal amount;
    private final Instant timestamp;

    public PaymentSucceededEvent(String orderId, String paymentId,
                                 BigDecimal amount, Instant timestamp) {
        this.orderId = orderId;
        this.paymentId = paymentId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}

