package com.gic.orders.dto;

import java.math.BigDecimal;

public class OrderResponse {

    private String orderId;

    private BigDecimal amount;

    private String customerEmail;
    public OrderResponse(String orderId, BigDecimal amount, String customerEmail) {
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
