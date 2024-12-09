package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.Property;
import com.example.realEstateCk.model.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {
//    public PropertyDetails findByPropertyId(Long properties);
    public PropertyDetails findByProperties(Property property);
}
