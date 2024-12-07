package com.example.realEstateCk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // id là kiểu BITINT, sử dụng Long trong Java

    private String name; // name là kiểu VARCHAR(255)

    private Boolean hide = false; // hide là kiểu BIT, trong Java sẽ là kiểu Boolean, mặc định là false

    // Constructors
    public Location() {
    }

    public Location(String name, Boolean hide) {
        this.name = name;
        this.hide = hide;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getHide() {
        return hide;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }
}
