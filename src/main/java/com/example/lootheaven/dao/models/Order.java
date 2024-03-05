package com.example.lootheaven.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "totalAmount")
    private Long totalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "orderDate")
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "adUnitId")
    private AdUnit adUnit;

    @ManyToOne
    @JoinColumn(name = "customer")
    private User user;

    @OneToOne(mappedBy = "order")
    private Payment payment;
}
