package com.example.lootheaven.dao.repository;

import com.example.lootheaven.dao.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
    User findByUsername(String username);
}
