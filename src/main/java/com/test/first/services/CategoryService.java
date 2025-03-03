package com.test.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.first.models.Category;
import com.test.first.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllCategories() {
        return (List<Category>) this.repository.findAll();
    }
    
    public Category getCategoryById(Long id) {
        return this.repository.findById(id).orElse(null);
    }
    
    public Category creaCategory(Category category) {
        return this.repository.save(category);
    }

    public Category updateCategory (Long id, Category category) {
        category.setId(id);
        return this.repository.save(category);
    }

    public void deleteCategory(Long id) {
        this.repository.deleteById(id);
    }
}
