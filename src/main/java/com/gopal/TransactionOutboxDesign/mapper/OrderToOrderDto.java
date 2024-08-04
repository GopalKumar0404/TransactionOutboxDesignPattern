package com.gopal.TransactionOutboxDesign.mapper;

import com.gopal.TransactionOutboxDesign.dto.OrderDto;
import com.gopal.TransactionOutboxDesign.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderDto {

    public OrderDto createOrderDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .price(order.getPrice())
                .name(order.getName())
                .quantity(order.getQuantity())
                .build();
    }
}
