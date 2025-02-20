package com.yassinecoding.gestiondestock.controller.api;

import com.yassinecoding.gestiondestock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ClientApi {
    @PostMapping(value = "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);
    @GetMapping(value = "/client/{clientId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("clientId") Integer id);
    @GetMapping(value = "/client/{clientNom}" , produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findByNom(@PathVariable("clientNom") String nom);
    @GetMapping(value = "/client/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();
    @DeleteMapping(value = "/client/delete/{clientId}")
    void delete(@PathVariable("clientId")  Integer id);

}
