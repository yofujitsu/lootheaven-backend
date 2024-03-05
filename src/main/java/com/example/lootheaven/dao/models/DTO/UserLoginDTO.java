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
public class UserLoginDTO {
    private String email;
    private String password;
}
