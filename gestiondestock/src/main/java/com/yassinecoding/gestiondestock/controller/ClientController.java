package com.yassinecoding.gestiondestock.controller;


import com.yassinecoding.gestiondestock.controller.api.ClientApi;
import com.yassinecoding.gestiondestock.dto.ClientDto;
import com.yassinecoding.gestiondestock.services.ClientService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController implements ClientApi {

    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto findByNom(String nom) {
        return clientService.findByNom(nom);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);

    }
}
