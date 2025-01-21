package com.yassinecoding.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movementStock")
public class MovementStock extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

}
