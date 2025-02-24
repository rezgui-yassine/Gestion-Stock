package com.yassinecoding.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yassinecoding.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;
    private String code;
    private String designation;
    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> articles;

    // creer une methode pour convertir un objet en DTO
    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
            // TODO throw an exception if category is null
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .idEntreprise(category.getIdEntreprise())
                .build();
    }
    // creer une methode pour convertir un DTO en objet
    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto==null){
            return  null;
            // TODO throw an exception if categoryDto is null
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());
        return category;


    }
}