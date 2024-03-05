package com.example.lootheaven.dao.models;

import com.example.lootheaven.dao.models.enums.UserRole;
import com.example.lootheaven.dao.models.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<AdUnit> adUnits;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Column(name = "regDate")
    private LocalDate regDate;

    @Column(name = "rating")
    private Long rating;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "avatarImg")
    private String avatarImg;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Column(name = "balance")
    private Long balance;

}
