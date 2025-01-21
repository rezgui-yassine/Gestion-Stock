package com.yassinecoding.gestiondestock.dto;


import com.yassinecoding.gestiondestock.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ArticleDto {

    private String codeArticle;

    private String designation;

    private BigDecimal priceUnitaireHt;

    private BigDecimal tauxTva;


    private BigDecimal prixUnitaireTtc;

    private String photo;

    private Category category;
}
