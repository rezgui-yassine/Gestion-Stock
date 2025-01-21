package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Fournisseur;
import com.yassinecoding.gestiondestock.model.LigneCommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeFournisseurDto {


    private String code;


    private Instant dateCommande;


    private Fournisseur fournisseur;

    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;
}
