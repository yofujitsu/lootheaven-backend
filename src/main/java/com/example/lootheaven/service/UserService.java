package com.example.lootheaven.service;

import com.example.lootheaven.dao.models.DTO.UserLoginDTO;
import com.example.lootheaven.dao.models.User;
import com.example.lootheaven.dao.models.DTO.UserRegDTO;
import com.example.lootheaven.dao.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User registerUser(UserRegDTO userRegDTO) {
        User newUser = new User();
        newUser.setUsername(userRegDTO.getUsername());
        newUser.setEmail(userRegDTO.getEmail());
        newUser.setAvatarImg(userRegDTO.getAvatarImg());;
        newUser.setActive(true);
        newUser.setPassword(passwordEncoder.encode(userRegDTO.getPassword()));
        newUser.setBalance(0L);
        newUser.setRegDate(LocalDate.now());
        newUser.setRating(0L);
        newUser.setRole(userRegDTO.getRole());
        userRepository.save(newUser);
        return newUser;
    }

    public Optional<User> validateAuthCandidate(String email, String password) {
        try {
            User user = userRepository.findByEmail(email);
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
