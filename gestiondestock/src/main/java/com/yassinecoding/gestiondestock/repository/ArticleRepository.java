package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findArticleByCodeArticle(String codeArticle);
    // ecrire une requete personalisee




    @Query("select a from Article a where a.designation = :designation")
    List<Article> findByDesignation(String designation);

    @Query("select a from Article a where a.category.id = :categoryId")
    List<Article> findByCategoryId(Integer categoryId);
}
