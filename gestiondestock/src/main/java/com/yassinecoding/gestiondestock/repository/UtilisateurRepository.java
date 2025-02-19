package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository< Utilisateur ,Integer > {
}
