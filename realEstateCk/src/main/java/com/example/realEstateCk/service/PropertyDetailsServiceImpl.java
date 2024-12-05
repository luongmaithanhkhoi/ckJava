package com.example.realEstateCk.service;

import com.example.realEstateCk.model.PropertyDetails;
import com.example.realEstateCk.repository.PropertyDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {
    @Autowired
    private PropertyDetailsRepository propertyDetailsRepository;
    @Override
    public PropertyDetails getPropertyDetailsById(Long id) {
        return propertyDetailsRepository.findById(id).get();
    }
}
