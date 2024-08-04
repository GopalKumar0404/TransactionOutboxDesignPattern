package com.gopal.TransactionOutboxDesign.services;

import com.gopal.TransactionOutboxDesign.dto.OrderDto;
import com.gopal.TransactionOutboxDesign.entity.Order;
import com.gopal.TransactionOutboxDesign.entity.OrderOutbox;
import com.gopal.TransactionOutboxDesign.mapper.OrderToOrderDto;
import com.gopal.TransactionOutboxDesign.mapper.OrderToOutbox;
import com.gopal.TransactionOutboxDesign.mapper.OrdertDtoToOrder;
import com.gopal.TransactionOutboxDesign.repository.OrderRepository;
import com.gopal.TransactionOutboxDesign.repository.OutboxRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrdertDtoToOrder order;
    @Autowired
    private OrderToOutbox orderToOutbox;
    @Autowired
    private OutboxRepository outboxRepository;

    @Transactional
    public Order saveOrder(OrderDto orderDto){

        log.info("Received Object : {}",orderDto.toString());
        Order order = this.order.createOrder(orderDto);
        order = orderRepository.save(order);
        log.info("Persisted Object : {}",order.toString());
        OrderOutbox outbox = orderToOutbox.createOutbox(order);
        outboxRepository.save(outbox);

        log.info("Persisted Object to database");

        return order;
    }
}
