package com.example.lootheaven.dao.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private int rating;

    @Column(name = "reviewDate")
    private LocalDateTime reviewDate;
}
