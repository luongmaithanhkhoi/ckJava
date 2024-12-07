//package com.example.realEstateCk.Service;
//
//import com.example.realEstateCk.Model.RealEstate;
//import com.example.realEstateCk.Repository.RealEstateRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class RealEstateService {
//    @Autowired
//    private RealEstateRepository realEstateRepository;
//
////    public List<RealEstate> getAllRealEstates() {
////        return realEstateRepository.findAll();
////    }
//    public Page<RealEstate> getRealEstates(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        return realEstateRepository.findAll(pageable);
//    }
//
//    public RealEstate getRealEstateById(Long id) {
//        return realEstateRepository.findById(id).orElse(null);
//    }
//}
