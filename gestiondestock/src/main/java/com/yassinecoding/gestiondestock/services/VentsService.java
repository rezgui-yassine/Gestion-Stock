package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.VentsDto;

import java.util.List;

public interface VentsService {

    VentsDto save(VentsDto dto);
    VentsDto findById(Integer id);
    VentsDto findByCode(String code);
    List<VentsDto> findAll();
    void delete(Integer id);

}
