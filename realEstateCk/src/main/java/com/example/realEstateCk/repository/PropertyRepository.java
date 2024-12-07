package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    public Property findByTitle(String title);
    @Query("SELECT p FROM Property p " +
            "WHERE (:categoryId IS NULL OR p.category.id = :categoryId) " +
            "AND (:locationId IS NULL OR p.location.id = :locationId) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice)")

    Page<Property> findPropertiesByFilters(
            @Param("categoryId") Long categoryId,
            @Param("locationId") Long locationId,
            @Param("minPrice") Double minPrice,
            @Param("maxPrice") Double maxPrice,
            Pageable pageable
    );
}
