package com.yassinecoding.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movementStock")
public class MovementStock extends AbstractEntity {

    @Column(name = "dateMvt")
    private Instant dateMvt;
    @Column(name = "quantiteMvt")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

    @Column(name = "typeMvt")
    private TypeMvtStk typeMvt;

}
