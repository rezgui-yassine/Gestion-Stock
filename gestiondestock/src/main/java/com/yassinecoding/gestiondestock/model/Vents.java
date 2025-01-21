package com.yassinecoding.gestiondestock.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

@Table(name = "vents")
public class Vents extends AbstractEntity {


    @Column(name = "code")
    private String code;
    @Column(name = "dateVente")
    private Instant dateVente;
    @Column(name = "commentaire")
    private String commentaire;
}
