package com.example.lootheaven.dao.repository;

import com.example.lootheaven.dao.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review, Long> {
}
