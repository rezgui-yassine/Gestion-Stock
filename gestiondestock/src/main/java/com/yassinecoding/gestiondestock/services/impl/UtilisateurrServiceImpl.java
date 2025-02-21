package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.UtilisateurDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Utilisateur;
import com.yassinecoding.gestiondestock.repository.FournisseurRepository;
import com.yassinecoding.gestiondestock.repository.UtilisateurRepository;
import com.yassinecoding.gestiondestock.services.UtilisateurService;
import com.yassinecoding.gestiondestock.validator.UtilisateurValidateur;
import jdk.jshell.execution.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurrServiceImpl implements UtilisateurService {

    private final FournisseurRepository fournisseurRepository;
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurrServiceImpl (UtilisateurRepository utilisateurRepository, FournisseurRepository fournisseurRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        // verificetion when saving a user

        List<String>errors = UtilisateurValidateur.validate(utilisateurDto);
        if(!errors.isEmpty()){
            log.error("Utilisateur is not valid {}", utilisateurDto);
            throw  new InvalidEntityException(" L'utilisateur n'est pas valide ", ErrorCode.UTILISATEUR_NOT_VALID, errors);
        }

        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(UtilisateurDto.toEntity(utilisateurDto))
        );
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id == null){
            log.error("Utilisateur ID is null");
            return null;
        }
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        return optionalUtilisateur
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "Aucun utilisateur avec l'ID = " + id + " n'a été trouvé dans la BDD",
                                ErrorCode.UTILISATEUR_NOT_FOUND
                        )
                )
                ;
    }

    @Override
    public UtilisateurDto findByEmail(String email) {
        Optional<Utilisateur>optionalUtilisateur = utilisateurRepository.findByEmail(email);

        return optionalUtilisateur
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "Aucun Utilisateur avec l 'email = "+email+" n'a été trouvé dans la BDD",
                                ErrorCode.UTILISATEUR_NOT_FOUND
                        )
                )
                ;
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll()
                .stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        if(id == null){
            log.error("Utilisateur ID is null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }
}
