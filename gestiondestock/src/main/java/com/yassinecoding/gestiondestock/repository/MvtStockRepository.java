package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.MovementStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStockRepository extends JpaRepository<MovementStock, Integer> {
}