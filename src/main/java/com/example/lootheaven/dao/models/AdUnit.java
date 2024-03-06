package com.example.lootheaven.dao.models;

import com.example.lootheaven.dao.models.enums.AdUnitType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.web.server.csrf.ServerCsrfTokenRequestAttributeHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ads")
public class AdUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "adUnitType")
    private AdUnitType adUnitType;

    @Column(name = "price")
    private Long price;

    @Column(name = "published")
    private LocalDateTime published;

    @ManyToOne
    @JoinColumn(name = "sellerId")
    private User user;

    @Column(name = "description")
    private String desc;

    @Column(name = "quantity")
    private Long quantity;

    @OneToMany(mappedBy = "adUnit")
    private List<Order> orders;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "game_item")
    private String game;

}
