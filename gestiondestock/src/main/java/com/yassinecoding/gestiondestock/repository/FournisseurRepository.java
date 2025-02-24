package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.dto.FournisseurDto;
import com.yassinecoding.gestiondestock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    Optional<Fournisseur> findFournisseurById(Integer id);
    Optional<Fournisseur> findFournisseurByNom(String nom);



}