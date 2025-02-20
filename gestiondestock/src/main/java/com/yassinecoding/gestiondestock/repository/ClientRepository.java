package com.yassinecoding.gestiondestock.repository;

import com.yassinecoding.gestiondestock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findClientByNom(String nom);
    Optional<Client>findClientById(Integer id);

}
