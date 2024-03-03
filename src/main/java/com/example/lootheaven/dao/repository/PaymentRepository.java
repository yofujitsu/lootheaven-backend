package com.example.lootheaven.dao.repository;

import com.example.lootheaven.dao.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
