package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.FournisseurDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Fournisseur;
import com.yassinecoding.gestiondestock.repository.FournisseurRepository;
import com.yassinecoding.gestiondestock.services.FournisseurService;
import com.yassinecoding.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
           log.error("Fournisseur is not valid {}", dto);
            throw new InvalidEntityException("Le fournisseur n'est pas valid", ErrorCode.FOURNISSEUR_NOT_VALID, errors);
        }



        return FournisseurDto.fromEntity(
                fournisseurRepository.save(FournisseurDto.toEntity(dto))
        );
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id ==null){
            log.error("Fournisseur ID is null");
            return null;
        }
        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findFournisseurById(id);

        return fournisseurOptional
                .map(FournisseurDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                "Aucun fournisseur avec l'ID = " + id + " n'a été trouvé dans la BDD"
                        )
                );
    }

    @Override
    public FournisseurDto findByNom(String nom) {
        if(nom.isEmpty()){
            log.error("Fournisseur nom is empty");
            return null;
        }
        Optional<Fournisseur>fournisseurOptional =fournisseurRepository.findFournisseurByNom(nom);
        return fournisseurOptional
                .map(FournisseurDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException("Aucun fournisseur avec le nom = " + nom + " n'a été trouvé dans la BDD")
                )
                ;
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList()) ;

    }

    @Override
    public void delete(Integer id) {
        fournisseurRepository.deleteById(id);

    }
}
