package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Utilisateur;
import com.yassinecoding.gestiondestock.model.Vents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenteRepository extends JpaRepository< Vents  ,Integer> {
    Optional<Vents> findById(Integer integer);

    Optional<Vents> findVentsByCode(String code);

}
