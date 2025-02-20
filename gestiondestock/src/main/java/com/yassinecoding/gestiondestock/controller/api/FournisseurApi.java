package com.yassinecoding.gestiondestock.controller.api;

import com.yassinecoding.gestiondestock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface FournisseurApi  {


@PostMapping(value = "/fournisseurs/create" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    FournisseurDto save(@RequestBody FournisseurDto dto);
    @GetMapping(value = "/fournisseurs/{idFournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);
    @GetMapping(value = "/fournisseur/{nomFournisseur}" , produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findByNom(@PathVariable("nomFournisseur")  String nom);
    @GetMapping(value = "/fournisseurs" , produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();
    @DeleteMapping(value = "/fournisseurs/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);
}
