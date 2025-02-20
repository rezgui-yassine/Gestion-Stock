package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto dto);
    ClientDto findById(Integer id);
    ClientDto findByNom(String nom);
    List <ClientDto> findAll();
    void delete(Integer id);
}
