package com.example.lootheaven.dao.models;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private Order order;
    private String comment;
    private int rating;
    private LocalDateTime reviewDate;
    private User reviewer;
}
