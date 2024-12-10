package com.example.realEstateCk.service;

import com.example.realEstateCk.model.CityPropertyDTO;
import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Page<Property> findPropertiesByFilters(Long categoryId, Long locationId, Double minPrice, Double maxPrice, Pageable pageable) {
        return propertyRepository.findPropertiesByFilters(categoryId, locationId, minPrice, maxPrice, pageable);
    }

    @Override
    public List<CityPropertyDTO> getTopCitiesWithMostProperties() {
        Pageable topThree = PageRequest.of(0, 3); // Lấy top 3
        return propertyRepository.findTopCitiesWithMostProperties(topThree);
    }


}
