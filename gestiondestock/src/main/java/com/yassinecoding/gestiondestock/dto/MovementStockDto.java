package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Article;
import com.yassinecoding.gestiondestock.model.MovementStock;
import com.yassinecoding.gestiondestock.model.TypeMvtStk;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
@Data
public class MovementStockDto {
    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto article;

    private TypeMvtStk typeMvt;

    private Integer idEntreprise;

    // Create a method to convert an object to DTO
    public static MovementStockDto fromEntity (MovementStock movementStock){
        if (movementStock == null){
            return null;
            // TODO throw an exception if movementStock is null
      }
        return  MovementStockDto.builder()
                .id(movementStock.getId())
                .dateMvt(movementStock.getDateMvt())
                .quantite(movementStock.getQuantite())
                .article(ArticleDto.fromEntity(movementStock.getArticle()))
                .typeMvt(movementStock.getTypeMvt())
                .idEntreprise(movementStock.getIdEntreprise())
                .build();

    }

    // Create a method to convert a DTO to an object
    public static MovementStock toEntity (MovementStockDto movementStockDto){
        if (movementStockDto == null){
            return null;
            // TODO throw an exception if movementStockDto is null
        }
        MovementStock movementStock = new MovementStock();
        movementStock.setId(movementStockDto.getId());
        movementStock.setDateMvt(movementStockDto.getDateMvt());
        movementStock.setQuantite(movementStockDto.getQuantite());
        movementStock.setArticle(ArticleDto.toEntity(movementStockDto.getArticle()));
        movementStock.setTypeMvt(movementStockDto.getTypeMvt());
        return movementStock;
    }

}
