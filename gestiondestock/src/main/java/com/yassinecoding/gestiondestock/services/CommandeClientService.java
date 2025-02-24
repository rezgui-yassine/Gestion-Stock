package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();
    void delete(Integer id);
}
