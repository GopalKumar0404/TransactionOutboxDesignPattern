package com.gopal.TransactionOutboxDesign.mapper;

import com.gopal.TransactionOutboxDesign.dto.OrderDto;
import com.gopal.TransactionOutboxDesign.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrdertDtoToOrder {

    public Order createOrder(OrderDto order) {
        return Order.builder()
                .price(order.getPrice())
                .name(order.getName())
                .quantity(order.getQuantity())
                .build();
    }
}
