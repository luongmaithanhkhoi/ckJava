package com.example.realEstateCk.service;

import com.example.realEstateCk.model.CityPropertyDTO;
import com.example.realEstateCk.model.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PropertyService {
    public Iterable<Property> findByDescription(String description);
    public Iterable<Property> findByNameContaining(String name);
    public Iterable<Property> findByDescriptionContaining(String description);
    public Iterable<Property> findByNameContainingAndDescriptionContaining(String name, String description);
    public Iterable<Property> getAllPropertyHome();
    public Page<Property> getAllProperty(int page, int size);
    public Property getPropertyById(Long id);
    Page<Property> findPropertiesByFilters(Long categoryId, Long locationId, Double minPrice, Double maxPrice, Pageable pageable);
    public List<CityPropertyDTO> getTopCitiesWithMostProperties();
}
