package com.yassinecoding.gestiondestock.controller;


import com.yassinecoding.gestiondestock.controller.api.FournisseurApi;
import com.yassinecoding.gestiondestock.dto.FournisseurDto;
import com.yassinecoding.gestiondestock.services.FournisseurService;
import com.yassinecoding.gestiondestock.services.impl.FournisseurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FournisseurController implements FournisseurApi {

    private FournisseurServiceImpl fournisseurServiceImpl;
    @Autowired
    public FournisseurController(FournisseurServiceImpl fournisseurServiceImpl){
        this.fournisseurServiceImpl=fournisseurServiceImpl;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurServiceImpl.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurServiceImpl.findById(id);
    }

    @Override
    public FournisseurDto findByNom(String nom) {
        return fournisseurServiceImpl.findByNom(nom);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurServiceImpl.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurServiceImpl.delete(id);
    }
}
