package com.yassinecoding.gestiondestock.dto;


import com.yassinecoding.gestiondestock.model.Article;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class CategoryDto {


    private String code;

    private String designation;

    private List<Article> articles;
}
