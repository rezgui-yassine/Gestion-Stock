package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.CommandeFournisseurDto;
import com.yassinecoding.gestiondestock.dto.FournisseurDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.CommandeFournisseur;
import com.yassinecoding.gestiondestock.model.Fournisseur;
import com.yassinecoding.gestiondestock.repository.*;
import com.yassinecoding.gestiondestock.services.CommandeFournisseurService;
import com.yassinecoding.gestiondestock.services.FournisseurService;
import com.yassinecoding.gestiondestock.validator.CommandeFournisseurValidator;
import com.yassinecoding.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {



    private FournisseurRepository fournisseurRepository;

    private CommandeFournisseurRepository commandeFournisseurRepository;


    @Autowired
    public CommandeFournisseurServiceImpl(FournisseurRepository fournisseurRepository, CommandeFournisseurRepository commandeFournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
        this.commandeFournisseurRepository = commandeFournisseurRepository;
    }



    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        // Validate the CommandeFournisseurDto object and collect any validation errors
        List<String> errors = CommandeFournisseurValidator.validate(dto);

        // If there are validation errors, log the error and throw an InvalidEntityException
        if (!errors.isEmpty()) {
            log.error("Commande Fournisseur is not valid {}", dto);
            throw new InvalidEntityException("La commande fournisseur n'est pas valide", ErrorCode.COMMANDE_FOURNISSEUR_NOT_VALID, errors);
        }

        // Retrieve the fournisseur from the repository using the fournisseur ID from the DTO
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());

        // If the fournisseur is not found, log a warning and throw an EntityNotFoundException
        if (fournisseur.isEmpty()) {
            log.warn("Fournisseur with ID {} was not found in the DB", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'ID " + dto.getFournisseur().getId() + " n'a été trouvé dans la base de données", ErrorCode.FOURNISSEUR_NOT_FOUND);
        }

        // Convert the DTO to entity
        CommandeFournisseur commandeFournisseur = CommandeFournisseurDto.toEntity(dto);
        commandeFournisseur.setFournisseur(fournisseur.get());

        // Save the CommandeFournisseur entity
        CommandeFournisseur savedCommandeFournisseur = commandeFournisseurRepository.save(commandeFournisseur);

        // Convert the saved entity back to DTO and return
        return CommandeFournisseurDto.fromEntity(savedCommandeFournisseur);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        return null;
    }

    @Override
    public CommandeFournisseurDto findByNom(String nom) {
        return null;
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }


}
