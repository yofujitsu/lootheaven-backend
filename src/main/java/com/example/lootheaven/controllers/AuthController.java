package com.example.lootheaven.controllers;

import com.example.lootheaven.dao.models.DTO.AuthDTO;
import com.example.lootheaven.dao.models.DTO.UserLoginDTO;
import com.example.lootheaven.dao.models.DTO.UserRegDTO;
import com.example.lootheaven.dao.models.User;
import com.example.lootheaven.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthDTO> login(@RequestBody UserLoginDTO loginDto) {
        Optional<User> userOptional = userService.validateAuthCandidate(loginDto.getEmail(), loginDto.getPassword());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getActive()) {
                return ResponseEntity.ok(new AuthDTO(
                        user.getId(),
                        user.getEmail(),
                        user.getUsername(),
                        user.getRole().name(),
                        user.getAvatarImg(),
                        true));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegDTO userRegDTO) {
        User newUser = userService.registerUser(userRegDTO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
