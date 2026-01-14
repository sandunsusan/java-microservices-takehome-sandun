package com.gic.payments.domain;

import java.math.BigDecimal;
import java.time.Instant;

public class Payment {

    private final String paymentId;
    private final String orderId;
    private final BigDecimal amount;
    private final Instant timestamp;

    public Payment(String paymentId, String orderId,
                   BigDecimal amount, Instant timestamp) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}
