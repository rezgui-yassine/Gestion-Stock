package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Adresse;
import com.yassinecoding.gestiondestock.model.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class EntrepriseDto
{
    private Integer id;
    private String nom;


    private String description;


    private AdresseDto adresse;


    private String codeFiscal;


    private String photo;


    private String email;

    private String numTel;


    private String siteWeb;


    private List<UtilisateurDto> utilisateurs;
}
