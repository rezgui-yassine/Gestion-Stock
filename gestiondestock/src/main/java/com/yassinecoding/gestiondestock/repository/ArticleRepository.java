package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article>findArticleById(Integer id);
    Optional<Article> findArticleByCodeArticle(String codeArticle);
    // ecrire une requete personalisee

//    @Query("select a from Article a where a.codeArticle = :code and a.designation = :designation")
//    List<Article> findByCustomerQuery(@Param("code") String code, @Param("designation") String designation);
//
//    // i write native query for the same query
//    @Query(value = "select * from Article a where a.codeArticle = :code ", nativeQuery = true)
//    List<Article> findByCustomerQueryNative(@Param("code") String code);
//
//    //
//    List<Article> findByCodeArticleIgnoreCaseAAndDesignation(String codeArticle,String designation);


}
