package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Vents;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
}
