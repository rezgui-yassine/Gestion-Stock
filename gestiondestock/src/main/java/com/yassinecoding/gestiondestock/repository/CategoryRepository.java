package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<  Category, Integer > {
}
