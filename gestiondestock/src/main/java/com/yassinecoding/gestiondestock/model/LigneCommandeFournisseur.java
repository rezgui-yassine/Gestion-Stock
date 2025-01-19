package com.yassinecoding.gestiondestock.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ligne_commande_fournisseur")

public class LigneCommandeFournisseur extends AbstractEntity {
}
