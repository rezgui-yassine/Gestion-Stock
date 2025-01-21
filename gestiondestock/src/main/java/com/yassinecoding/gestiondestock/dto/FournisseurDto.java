package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Adresse;
import com.yassinecoding.gestiondestock.model.CommandeFournisseur;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FournisseurDto {

    private String nom;

    private String prenom;


    private Adresse adresse;


    private String photo;


    private String mail;

    private String numTel;


    private List<CommandeFournisseur> commandeFournisseurs;

}
