package com.gic.orders.OrderCreatedEvent;

import com.gic.orders.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class OrderRepository {

    private final List<Order> orders = new CopyOnWriteArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> findAll() {
        return List.copyOf(orders);
    }
}

