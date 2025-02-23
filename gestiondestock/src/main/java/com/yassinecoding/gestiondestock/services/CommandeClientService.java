package com.yassinecoding.gestiondestock.services;

import com.yassinecoding.gestiondestock.dto.CommandeClientDto;
import com.yassinecoding.gestiondestock.model.CommandeClient;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);
    CommandeClientDto findById(Integer id);
    CommandeClientDto findByCode(String code);
//    CommandeClientDto findByClientId(Integer id);
//    CommandeClientDto findByClientIdAndCommandeId(Integer clientId, Integer commandeId);
//    CommandeClientDto findByCodeCommande(String codeCommande);
    List<CommandeClientDto> findAll();
    void delete(Integer id);
}
