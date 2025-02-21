package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository< Utilisateur ,Integer > {

    Optional<Utilisateur> findById(Integer integer);
    Optional<Utilisateur> findByEmail(String email);
    void deleteById(Integer integer);
}
