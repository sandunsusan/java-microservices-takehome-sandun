package com.gic.orders.domain.event;

import java.math.BigDecimal;

public class OrderCreatedEvent {

    private final String orderId;
    private final BigDecimal amount;
    private final String customerEmail;

    public OrderCreatedEvent(String orderId, BigDecimal amount, String customerEmail) {
        this.orderId = orderId;
        this.amount = amount;
        this.customerEmail = customerEmail;
    }

    public String getOrderId() {
        return orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }
}

