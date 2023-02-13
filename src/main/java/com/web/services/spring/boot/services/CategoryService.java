package com.web.services.spring.boot.services;

import com.web.services.spring.boot.entities.Category;
import com.web.services.spring.boot.repositories.CategoryRepository;
import com.web.services.spring.boot.services.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Category findById (Long id) {
        boolean hasCategory = categoryRepository.findById(id).isPresent();
        if (!hasCategory) {
            throw new NotFoundException("Category not found");
        }
        return categoryRepository.findById(id).get();
    }
}
