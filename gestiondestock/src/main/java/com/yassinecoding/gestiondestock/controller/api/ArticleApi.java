package com.yassinecoding.gestiondestock.controller.api;

import com.yassinecoding.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

public interface ArticleApi {



    @PostMapping(value = "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = "/article/{articleId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("articleId") Integer id);

    @GetMapping(value = "/article/{codeArticle}" , produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    @GetMapping(value = "/article/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = "/article/delete/{articleId}")
    void deleteArticle(@PathVariable("articleId") Integer id);

}