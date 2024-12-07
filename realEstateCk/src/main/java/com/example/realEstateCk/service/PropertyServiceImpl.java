package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Iterable<Property> getAllPropertyHome() {
        return propertyRepository.findAll();
    }
    @Override
    public Page<Property> getAllProperty(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return propertyRepository.findAll(pageable);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).get();
    }
}
