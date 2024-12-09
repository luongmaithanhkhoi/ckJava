package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public Iterable<Property> findByDescription(String description) {
        return null;
    }

    @Override
    public Iterable<Property> findByNameContaining(String name) {
        return null;
    }

    @Override
    public Iterable<Property> findByDescriptionContaining(String description) {
        return null;
    }

    @Override
    public Iterable<Property> findByNameContainingAndDescriptionContaining(String name, String description) {
        return null;
    }

    @Override
    public Iterable<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).get();
    }

    @Override
    public Iterable<Property> findByOwnerId(Long ownerId) {
        return propertyRepository.findByOwnerId(ownerId);
    }

    @Override
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    @Override
    public void deleteById(Long id) {
         propertyRepository.deleteById(id);
    }


}
