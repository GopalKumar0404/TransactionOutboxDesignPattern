package com.gopal.TransactionOutboxDesign.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gopal.TransactionOutboxDesign.entity.Order;
import com.gopal.TransactionOutboxDesign.entity.OrderOutbox;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderToOutbox {

    @SneakyThrows
    public OrderOutbox createOutbox(Order order){
        return OrderOutbox.builder()
                .id(order.getId().toString())
                .payLoad(new ObjectMapper().writeValueAsString(order))
                .createdAt(new Date())
                .processed(false)
                .build();
    }
}
