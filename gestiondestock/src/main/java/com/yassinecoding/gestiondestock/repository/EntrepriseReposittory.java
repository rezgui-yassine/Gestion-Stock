package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface EntrepriseReposittory extends JpaRepository< Entreprise , Integer > {
    Optional<Entreprise>findById(Integer id);
    Optional<Entreprise>findByNom(String nom);
    Optional<Entreprise> findByCodeFiscal(String codeFiscal);
}
