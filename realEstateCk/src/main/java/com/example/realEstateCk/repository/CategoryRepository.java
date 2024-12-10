package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
