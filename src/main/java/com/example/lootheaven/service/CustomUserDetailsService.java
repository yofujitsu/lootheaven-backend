package com.example.lootheaven.service;

import com.example.lootheaven.config.UserDetailsImpl;
import com.example.lootheaven.dao.models.User;
import com.example.lootheaven.dao.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        List<SimpleGrantedAuthority> authorities = Collections
                .singletonList(new SimpleGrantedAuthority(user.getRole().name()));
        return mapUserToCustomUserDetails(user, authorities);
    }

    private UserDetailsImpl mapUserToCustomUserDetails(User user, List<SimpleGrantedAuthority> authorities) {
        UserDetailsImpl userDetailsImpl = new UserDetailsImpl();
        userDetailsImpl.setId(user.getId());
        userDetailsImpl.setEmail(user.getEmail());
        userDetailsImpl.setHashPassword(user.getPassword());
        userDetailsImpl.setAuthorities(authorities);
        userDetailsImpl.setUser(user);
        return userDetailsImpl;
    }


}
