package com.example.lootheaven.service;

import com.example.lootheaven.dao.models.User;
import com.example.lootheaven.dao.repository.UserRepository;

import java.security.Principal;

public class UserService {
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
