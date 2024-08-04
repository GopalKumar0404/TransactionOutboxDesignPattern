package com.gopal.TransactionOutboxDesign.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderDto {
    private Long id;
    private String name;
    private Double price;
    private Float quantity;
}
