package com.yassinecoding.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity

@Table(name = "entreprise")
 public class Entreprise extends AbstractEntity {

 @Column(name = "nom")
 private String nom;

 @Column(name = "description")
 private String description;

 @Column(name = "adresse")
 private Adresse adresse;

 @Column(name = "codeFiscal")
 private String codeFiscal;

 @Column(name = "photo")
 private String photo;

 @Column(name = "email")
 private String email;
 @Column(name = "numTel")
 private String numTel;

 @Column(name = "siteWeb")
 private String siteWeb;

 @OneToMany(mappedBy = "entreprise")
 private List<Utilisateur> utilisateurs;


}
