package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
