package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Property;
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

    @Override
    public PropertyDetails savePropertyDetails(PropertyDetails propertyDetails) {
        return propertyDetailsRepository.save(propertyDetails);
    }

    @Override
    public PropertyDetails updatePropertyDetails(PropertyDetails propertyDetails) {
        return null;
    }

    @Override
    public void deletePropertyDetails(Long id) {
        propertyDetailsRepository.deleteById(id);
    }

    @Override
    public PropertyDetails findPropertyDetailsByIdProperty(Property property) {
        return propertyDetailsRepository.findByProperties(property);
    }

    @Override
    public void deletePropertyDetails(PropertyDetails propertyDetails) {
        propertyDetailsRepository.delete(propertyDetails);
    }

//    @Override
//    public PropertyDetails getPropertyDetailsByIdPro(Long properties) {
//        return propertyDetailsRepository.findByPropertyId(properties);
//    }
}
