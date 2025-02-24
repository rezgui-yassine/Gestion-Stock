package com.yassinecoding.gestiondestock.dto;


import com.yassinecoding.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {
    private Integer id;
    private String codeArticle;

    private String designation;

    private BigDecimal priceUnitaireHt;

    private BigDecimal tauxTva;


    private BigDecimal prixUnitaireTtc;

    private String photo;

    private Integer idEntreprise;

    private CategoryDto category;

    //  crrer une methode pour convertir un objet en DTO

    public static   ArticleDto fromEntity(Article article){
      if (article == null){
          return null;
          //TODO throw an exception if adresse is null
      }
      return ArticleDto.builder()
              .id(article.getId())
              .codeArticle(article.getCodeArticle())
              .designation(article.getDesignation())
              .priceUnitaireHt(article.getPriceUnitaireHt())
              .tauxTva(article.getTauxTva())
              .prixUnitaireTtc(article.getPrixUnitaireTtc())
              .photo(article.getPhoto())
              .idEntreprise(article.getIdEntreprise())
              .category(CategoryDto.fromEntity(article.getCategory()))
              .build();
    }

    // creer une methode pour convertir un DTO en objet
    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
            // TODO throw an exception if articleDto is null
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setDesignation(articleDto.getDesignation());
        article.setPriceUnitaireHt(articleDto.getPriceUnitaireHt());
        article.setTauxTva(articleDto.getTauxTva());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setPhoto(articleDto.getPhoto());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
        return article;
    }
}
