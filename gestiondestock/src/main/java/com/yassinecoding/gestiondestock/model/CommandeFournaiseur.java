package com.yassinecoding.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "commande_fournaiseur")
public class CommandeFournaiseur extends AbstractEntity {

    @Column(name = "code")
    private String code;


    @Column(name = "datecommande")
    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name = "idFournaiseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandeFournaiseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

}
