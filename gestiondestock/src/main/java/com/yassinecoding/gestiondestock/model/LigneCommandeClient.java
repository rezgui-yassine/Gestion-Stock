package com.yassinecoding.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ligne_commande_client")
public class LigneCommandeClient extends AbstractEntity {


    // i use the @ManyToOne annotation to specify the relationship between the LigneCommandeClient and the Article entities.
    // The @JoinColumn annotation is used to specify the column that will be used to join the two tables.
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    // i use the @ManyToOne annotation to specify the relationship between the LigneCommandeClient and the CommandeClient entities.
    // The @JoinColumn annotation is used to specify the column that will be used to join the two tables.
    @ManyToOne
    @JoinColumn(name = "idCommandeClient")
    private CommandeClient commandeClient;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;


}
