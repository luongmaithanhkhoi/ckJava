package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Location;
import com.example.realEstateCk.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    // Phương thức lấy danh sách tất cả các Location sắp xếp theo tên
    public List<Location> getAllLocations() {
        return locationRepository.findAllByOrderByNameAsc(); // Sắp xếp theo tên alphabet
    }
}