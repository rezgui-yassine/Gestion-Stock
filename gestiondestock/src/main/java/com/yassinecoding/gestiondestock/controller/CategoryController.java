package com.yassinecoding.gestiondestock.controller;


import com.yassinecoding.gestiondestock.controller.api.CategoryApi;
import com.yassinecoding.gestiondestock.dto.CategoryDto;
import com.yassinecoding.gestiondestock.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CategoryController implements CategoryApi {
    private CategoryService categoryService;
    @Autowired
    public CategoryController( CategoryService categoryService){
       this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCode(String code) {
        return categoryService.findByCode(code) ;
    }

    @Override
    public CategoryDto findByDesignation(String designation) {
        return categoryService.findByDesignation(designation);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {
        categoryService.delete(id);
    }
}
