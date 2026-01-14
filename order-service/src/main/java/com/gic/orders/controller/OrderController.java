package com.gic.orders.controller;

import com.gic.orders.domain.Order;
import com.gic.orders.dto.CreateOrderRequest;
import com.gic.orders.dto.OrderResponse;
import com.gic.orders.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Orders", description = "Order Management APIs")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(
            @Valid @RequestBody CreateOrderRequest request) {

        Order order = orderService.createOrder(
                request.getAmount(),
                request.getCustomerEmail()
        );

        return new OrderResponse(
                order.getOrderId(),
                order.getAmount(),
                order.getCustomerEmail()
        );
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders()
                .stream()
                .map(o -> new OrderResponse(
                        o.getOrderId(),
                        o.getAmount(),
                        o.getCustomerEmail()))
                .toList();
    }
}
