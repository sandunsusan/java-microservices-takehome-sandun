package com.gic.orders;

import com.gic.orders.OrderCreatedEvent.OrderRepository;
import com.gic.orders.domain.Order;
import com.gic.orders.domain.event.OrderCreatedEvent;
import com.gic.orders.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ApplicationEventPublisher eventPublisher;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldCreateOrderAndPublishEvent() {
        // given
        BigDecimal amount = BigDecimal.valueOf(49.99);
        String email = "user@example.com";

        // when
        Order order = orderService.createOrder(amount, email);

        // then
        assertNotNull(order);
        assertEquals(amount, order.getAmount());
        assertEquals(email, order.getCustomerEmail());

        verify(orderRepository).save(any(Order.class));
        verify(eventPublisher).publishEvent(any(OrderCreatedEvent.class));
    }
}

