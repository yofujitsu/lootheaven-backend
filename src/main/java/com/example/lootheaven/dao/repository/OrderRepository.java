package com.example.lootheaven.dao.repository;

import com.example.lootheaven.dao.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}
