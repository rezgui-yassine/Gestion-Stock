package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    FournisseurDto findByNom(String nom);

    List<FournisseurDto> findAll();

    void delete(Integer id);

//    FournisseurDto update(FournisseurDto dto, Integer id);
}
