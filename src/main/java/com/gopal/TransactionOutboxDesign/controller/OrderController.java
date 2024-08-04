package com.gopal.TransactionOutboxDesign.controller;

import com.gopal.TransactionOutboxDesign.dto.OrderDto;
import com.gopal.TransactionOutboxDesign.entity.Order;
import com.gopal.TransactionOutboxDesign.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactionOutBox/v1")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;

    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestBody OrderDto orderDto){
        Order order = orderService.saveOrder(orderDto);
        return ResponseEntity.ok().body(order);
    }
}
