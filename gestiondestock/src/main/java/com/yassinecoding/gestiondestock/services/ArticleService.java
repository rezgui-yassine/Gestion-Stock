package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<ArticleDto>findAll();

    void deleteArticle(Integer id);



}
