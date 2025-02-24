package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Vents;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VentsDto {
    private Integer id;
    private String code;
    private Instant dateVente;
    private String commentaire;
    private Integer idEntreprise;

    // Create a method to convert an object to DTO
    public static VentsDto fromEntity(Vents vente) {
        if (vente == null) {
            return null;
            // TODO throw an exception if vente is null
        }
        return VentsDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    // Create a method to convert a DTO to an object
    public static Vents toEntity(VentsDto venteDto) {
        if (venteDto == null) {
            return null;
            // TODO throw an exception if venteDto is null
        }
        Vents vente = new Vents();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setDateVente(venteDto.getDateVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}