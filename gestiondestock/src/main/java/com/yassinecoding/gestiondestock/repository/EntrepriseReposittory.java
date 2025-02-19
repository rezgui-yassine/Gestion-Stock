package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseReposittory extends JpaRepository< Entreprise , Integer > {
}
