package com.example.lootheaven.dao.models;

import com.example.lootheaven.dao.models.enums.UserRole;
import com.example.lootheaven.dao.models.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class User {
    private Long id;

    private String username;

    private String password;

    private String email;

    private List<Order> orders;

    private List<AdUnit> adUnits;

    private List<Review> reviews;

    private LocalDate regDate;

    private Long rating;

    private Boolean active;

    private String avatarImg;

    private UserStatus status;

    private UserRole role;

    private Long balance;

}
