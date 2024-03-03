package com.example.lootheaven.dao.models;

import java.time.LocalDateTime;

public class Payment {
    private Long id;

    private Long orderId;
    private Long amount;
    private String paymentMethod;
    private String status;
    private LocalDateTime paymentDate;
}
