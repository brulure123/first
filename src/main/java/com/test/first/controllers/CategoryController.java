package com.test.first.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.first.models.Category;
import com.test.first.services.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return this.categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public Category read(@PathVariable Long id) {
        return this.categoryService.getCategoryById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return this.categoryService.creaCategory(category);
    }

    @PutMapping("{id}")
    public Category update (@PathVariable Long id, @RequestBody Category category) {
        return this.categoryService.updateCategory(id, category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
    }
}
