package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    CategoryDto findById(Integer id);
    CategoryDto findByCode(String code);
    CategoryDto findByDesignation(String designation);
    List<CategoryDto> findAll();
    void delete (Integer id);

}
