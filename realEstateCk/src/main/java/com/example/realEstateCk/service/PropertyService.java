package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Property;

public interface PropertyService {
    public Iterable<Property> findByDescription(String description);
    public Iterable<Property> findByNameContaining(String name);
    public Iterable<Property> findByDescriptionContaining(String description);
    public Iterable<Property> findByNameContainingAndDescriptionContaining(String name, String description);
    public Iterable<Property> getAllProperty();
    public Property getPropertyById(Long id);
    public Iterable<Property> findByOwnerId(Long ownerId);
    public Property save(Property property);
    public void deleteById(Long id);
}
