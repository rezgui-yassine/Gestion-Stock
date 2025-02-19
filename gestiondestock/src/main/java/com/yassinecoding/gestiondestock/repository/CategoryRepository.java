package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<  Category, Integer > {
    Optional<Category> findCategoryById(Integer id);
    Optional<Category> findCategoryByCode(String code);
    Optional<Category> findCategoryByDesignation(String designation);
}
