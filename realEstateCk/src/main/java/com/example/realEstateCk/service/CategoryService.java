package com.example.realEstateCk.service;

import com.example.realEstateCk.model.Category;

public interface CategoryService {
    public Category getCategory(int id);
    public Iterable<Category> getAllCategories();
}
