package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class LigneVenteDto {
    private Integer id;
    private VentsDto vente;
    private BigDecimal quantite;
    private BigDecimal prixUnitaire;

    // Create a method to convert an object to DTO
    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
        if (ligneVente == null) {
            return null;
            // TODO throw an exception if ligneVente is null
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .vente(VentsDto.fromEntity(ligneVente.getVente()))
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }

    // Create a method to convert a DTO to an object
    public static LigneVente toEntity(LigneVenteDto ligneVenteDto) {
        if (ligneVenteDto == null) {
            return null;
            // TODO throw an exception if ligneVenteDto is null
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setVente(VentsDto.toEntity(ligneVenteDto.getVente()));
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        return ligneVente;
    }
}