package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);
    EntrepriseDto findById(Integer id);
    EntrepriseDto findByNom(String nom);
    List<EntrepriseDto>findAll();
    void delete(Integer id);

}
