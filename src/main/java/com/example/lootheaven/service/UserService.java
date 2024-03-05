package com.example.lootheaven.service;

import com.example.lootheaven.dao.models.DTO.UserLoginDTO;
import com.example.lootheaven.dao.models.User;
import com.example.lootheaven.dao.models.DTO.UserRegDTO;
import com.example.lootheaven.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.Principal;
import java.time.LocalDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private CustomUserDetailsService customUserDetailsService;
    private AuthenticationManager authenticationManager;

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

    public void login(String username, String password) {
        // Загружаем пользователя из базы данных по его имени пользователя (логину)
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        // Проверяем правильность введенного пароля
        if (!userDetails.getPassword().equals(password)) {
            throw new RuntimeException("Неправильное имя пользователя или пароль");
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        // Устанавливаем аутентификационный токен в контекст безопасности
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
