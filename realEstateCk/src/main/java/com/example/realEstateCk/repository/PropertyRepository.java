package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    public Property findByTitle(String title);
    public Iterable<Property> findByOwnerId(Long ownerId);
}
