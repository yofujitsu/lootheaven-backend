package com.example.lootheaven.dao.models.DTO;

import com.example.lootheaven.dao.models.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRegDTO {
    private Long id;
    private String email;
    private String password;
    private String username;
    private UserRole role;
    private String avatarImg;

}
