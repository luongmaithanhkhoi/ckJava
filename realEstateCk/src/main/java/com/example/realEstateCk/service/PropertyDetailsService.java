package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.model.PropertyDetails;

public interface PropertyDetailsService {
    public PropertyDetails getPropertyDetailsById(Long id);
    public PropertyDetails savePropertyDetails(PropertyDetails propertyDetails);
//    public PropertyDetails getPropertyDetailsByIdPro(Long properties);
    public PropertyDetails updatePropertyDetails(PropertyDetails propertyDetails);
    public void deletePropertyDetails(Long id);
    public PropertyDetails findPropertyDetailsByIdProperty(Property property);
    public void deletePropertyDetails(PropertyDetails propertyDetails);
}
