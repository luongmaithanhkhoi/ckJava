package com.example.realEstateCk.model;

import jakarta.persistence.*;

@Entity
public class about {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column
    private String image;
}
