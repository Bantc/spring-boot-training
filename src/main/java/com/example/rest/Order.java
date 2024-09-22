package com.example.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// POJO class
@ToString @Getter @Setter
public class Order {
    private String customerName;
    private String productName;
    private int quantity;
}
