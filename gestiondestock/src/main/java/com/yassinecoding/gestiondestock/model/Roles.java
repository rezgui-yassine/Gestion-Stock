package com.yassinecoding.gestiondestock.model;


import jakarta.persistence.*;
import lombok.*;

@Data

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity {

        @Column(name = "role_name")
        private String roleName;

        @ManyToOne
        @JoinColumn(name = "idUtilisateur")
        private Utilisateur utilisateur;
}
