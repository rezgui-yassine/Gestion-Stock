package com.yassinecoding.gestiondestock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// data annotation is used to generate getters and setters
@Data
@NoArgsConstructor
@AllArgsConstructor
// EqualsAndHashCode annotation is used to generate equals and hashcode methods
@EqualsAndHashCode(callSuper = true)
@Entity


@Table(name = "article")
public class Article extends AbstractEntity {
    //@size(min = 3, max = 20)
    @Column(name = "codeArticle")
   private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prixUnitaire")
    private BigDecimal priceUnitaireHt;

    @Column(name = "prixUnitaireTva")
    private BigDecimal tauxTva;

    @Column(name = "prixUnitaireTtc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;



}
