package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Adresse;
import com.yassinecoding.gestiondestock.model.Entreprise;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class UtilisateurDto {
    private Integer id;
    private String nom;

    private String prenom;

    private String email;

    private Instant DateDeNaissance;

    private String motDePasse;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;
}
