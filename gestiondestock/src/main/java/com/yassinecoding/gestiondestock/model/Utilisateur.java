package com.yassinecoding.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")

public class Utilisateur extends AbstractEntity {
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;

    @Column(name = "email")
    private String email;
    @Column(name = "dateDeNaissance")
    private Instant DateDeNaissance;
    @Column(name = "motDePasse")
    private String motDePasse;
    @Embedded
    private Adresse adresse;
    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idEntreprise")
    private Entreprise entreprise;
}
