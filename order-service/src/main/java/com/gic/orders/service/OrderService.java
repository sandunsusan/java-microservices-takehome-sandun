package com.gic.orders.service;

import com.gic.orders.OrderCreatedEvent.OrderRepository;
import com.gic.orders.domain.Order;
import com.gic.orders.domain.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    public OrderService(OrderRepository orderRepository,
                        ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    public Order createOrder(BigDecimal amount, String email) {
        String orderId = UUID.randomUUID().toString();

        Order order = new Order(orderId, amount, email);
        orderRepository.save(order);

        log.info("Order created: {}", orderId);

        // Publish event
        eventPublisher.publishEvent(
                new OrderCreatedEvent(orderId, amount, email)
        );

        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}

