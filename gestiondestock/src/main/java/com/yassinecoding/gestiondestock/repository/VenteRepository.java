package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Vents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository< Vents  ,Integer> {
}
