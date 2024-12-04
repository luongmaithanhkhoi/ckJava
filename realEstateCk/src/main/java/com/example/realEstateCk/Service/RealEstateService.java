package com.example.realEstateCk.Service;

import com.example.realEstateCk.Model.RealEstate;
import com.example.realEstateCk.Repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {
    @Autowired
    private RealEstateRepository realEstateRepository;

    public List<RealEstate> getAllRealEstates() {
        return realEstateRepository.findAll();
    }
}
