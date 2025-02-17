package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findArticleByCodeArticle(String codeArticle);
    
}
