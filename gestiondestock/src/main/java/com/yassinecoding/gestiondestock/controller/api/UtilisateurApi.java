package com.yassinecoding.gestiondestock.controller.api;

import com.yassinecoding.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UtilisateurApi {

    @PostMapping(value = "/utilisateurs/create" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto utilisateurDto);
    @GetMapping(value="/utilisateurs/{idUtilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(value="/utilisateurs/email/{emailUtilisateur}" , produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findByEmail(@PathVariable("emailUtilisateur") String email);
    @GetMapping(value = "/utilisateurs/all " , produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();
    @DeleteMapping(value = "/utilisateurs/delete/{idUtilisateur}")
    void deleteById(Integer id);
}
