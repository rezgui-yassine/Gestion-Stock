package com.yassinecoding.gestiondestock.controller;

import com.yassinecoding.gestiondestock.controller.api.UtilisateurApi;
import com.yassinecoding.gestiondestock.dto.UtilisateurDto;
import com.yassinecoding.gestiondestock.services.UtilisateurService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UtilisateurController implements UtilisateurApi {
    private UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService){
        this.utilisateurService=utilisateurService;
    }


    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return utilisateurService.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        return utilisateurService.findByEmail(email);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void deleteById(Integer id) {

        utilisateurService.deleteById(id);

    }
}
