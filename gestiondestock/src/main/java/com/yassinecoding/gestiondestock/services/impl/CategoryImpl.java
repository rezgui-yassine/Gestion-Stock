package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.CategoryDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.model.Category;
import com.yassinecoding.gestiondestock.repository.ArticleRepository;
import com.yassinecoding.gestiondestock.repository.CategoryRepository;
import com.yassinecoding.gestiondestock.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class CategoryImpl implements CategoryService {

    private final ArticleRepository articleRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryImpl(CategoryRepository categoryRepository, ArticleRepository articleRepository){
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }


    @Override
    public CategoryDto save(CategoryDto categoryDto) {

        // verification of the validity of the category

        if(categoryDto == null){
            log.error("Category is null");
            return null;
        }
        // save the category

        return CategoryDto.fromEntity(
                categoryRepository.save(CategoryDto.toEntity(categoryDto))
        );
    }

    @Override
    public CategoryDto findById(Integer id) {
        // verification of the validity of the category
        if(id == null){
            log.error("Category ID is null");
            return null;
        }
        // find the category by id and return it if it exists in the database
        if (categoryRepository.findById(id).isPresent()){
            return CategoryDto.fromEntity(categoryRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public CategoryDto findByCode(String code) {
        // verification of the validity of the category
        if (code.isEmpty()){
            log.error("Category code is empty");
            return null;
        }
        Optional<Category> categoryOptional = categoryRepository.findCategoryByCode(code);
        return categoryOptional
                .map(CategoryDto::fromEntity)
                .orElseThrow(
                        ()->
                                new EntityNotFoundException(
                                        "Aucune catégorie avec le code = " + code + " n'a été trouvée dans la BDD",
                                        ErrorCode.CATEGORY_NOT_FOUND
                                )
                );
    }

    @Override
    public CategoryDto findByDesignation(String designation) {
        // verification of the validity of the category
        if (designation.isEmpty()){
            log.error("Category designation is empty");
            return null;
        }
        Optional<Category>categoryOptional = categoryRepository.findCategoryByDesignation(designation);
        return categoryOptional
                .map(CategoryDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException("Aucune catégorie avec la designation = " + designation + " n'a été trouvée dans la BDD",
                                ErrorCode.CATEGORY_NOT_FOUND)
                );
    }

    @Override
    public List<CategoryDto> findAll() {
        // verification of the validity of the category
        if (categoryRepository.findAll().isEmpty()){
            log.error("No category found in the database");
            return null;
        }

        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        // verification of the validity of the category
        if (id == null){
            log.error("Category ID is null");
            return;
        }
        // delete the category
        categoryRepository.deleteById(id);

    }
}
