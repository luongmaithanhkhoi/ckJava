package com.example.realEstateCk.Repository;

import com.example.realEstateCk.Model.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealEstateRepository extends JpaRepository<RealEstate, Long> {
}
