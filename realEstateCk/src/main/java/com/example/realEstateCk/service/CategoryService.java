package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Category;
import com.example.realEstateCk.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Phương thức lấy danh sách tất cả các Category
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}