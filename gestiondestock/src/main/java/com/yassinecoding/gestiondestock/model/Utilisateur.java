package com.yassinecoding.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "utilisateur")

public class Utilisateur extends AbstractEntity {
    @Column(name = "nom_utilisateur")
    private String nom;
}
