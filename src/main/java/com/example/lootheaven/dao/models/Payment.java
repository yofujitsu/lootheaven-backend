package com.example.lootheaven.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "paymentMethod")
    private String paymentMethod;

    @Column(name = "status")
    private String status;

    @Column(name = "paymentDate")
    private LocalDateTime paymentDate;
}
