package com.yassinecoding.gestiondestock.controller.api;

import com.yassinecoding.gestiondestock.dto.EntrepriseDto;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface EntrepriseImpl {

    @PostMapping(value = "/entreprise/create" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);
    @GetMapping(value = "/entreprise/{idEntreprise}" , produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("idEntreprise") Integer id);
    @GetMapping(value = "/entreprise/{nomEntreprisse}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findByNom(@PathVariable("nomEntreprisse") String nom);
    @GetMapping(value = "entreprise/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();
    @DeleteMapping(value = "entreprise/delete/{idEntreprise}")
    void delete(@PathVariable("idEntreprise")Integer id);
}
