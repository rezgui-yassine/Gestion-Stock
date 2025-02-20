package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.EntrepriseDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Entreprise;
import com.yassinecoding.gestiondestock.repository.EntrepriseReposittory;
import com.yassinecoding.gestiondestock.services.EntrepriseService;
import com.yassinecoding.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntreprisseImpl implements EntrepriseService {

    private EntrepriseReposittory entrepriseReposittory;

    @Autowired
    public EntreprisseImpl    (EntrepriseReposittory entrepriseReposittory) {
        this.entrepriseReposittory = entrepriseReposittory;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String>errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("l'entreprise n'est pas valid", ErrorCode.ENTREPRISE_NOT_VALID, errors);
        }
        return EntrepriseDto.fromEntity(
                entrepriseReposittory.save(EntrepriseDto.toEntity(dto))
        );

    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if (id == null){
            log.error("Entreprise ID is null");
            return null;
        }
        Optional<Entreprise> entrepriseOptional =entrepriseReposittory.findById(id);
        return entrepriseOptional.map(
                EntrepriseDto::fromEntity)
                .orElseThrow  (()-> new EntityNotFoundException("Aucun entreprise avec l'ID = " + id + " n'a été trouvé dans la BDD"
                ));

    }

    @Override
    public EntrepriseDto findByNom(String nom) {
        if (nom.isEmpty()){
            log.error("Entreprise Nom is null");
            return null;
        }
        Optional<Entreprise>entrepriseOptional = entrepriseReposittory.findByNom(nom);
        return  entrepriseOptional.map(EntrepriseDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException("Aucun entreprise avec le nom = " + nom + " n'a été trouvé dans la BDD"
                        ));

    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseReposittory.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());


    }
    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Entreprise ID is null");
            return;
        }

        entrepriseReposittory.deleteById(id);

    }
}
