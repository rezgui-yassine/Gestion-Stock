package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.*;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.*;
import com.yassinecoding.gestiondestock.repository.*;
import com.yassinecoding.gestiondestock.services.CommandeFournisseurService;
import com.yassinecoding.gestiondestock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {



    private FournisseurRepository fournisseurRepository;

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private LigneCommandeFurnisseurRepository ligneCommandeFournisseurRepository;
    private ArticleRepository articleRepository;



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

        // Initialize a list to collect any article-related errors

        // Initialize a list to collect any article-related errors
        List<String> articleErrors = new ArrayList<>();

        // Verify that the ligneCommandeClients list is not null and that each article in the list is valid
        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdFrs  -> {
                if (ligCmdFrs .getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdFrs .getArticle().getId());
                    if (article.isEmpty()) {
                        log.warn("Article with ID {} was not found in the DB", ligCmdFrs .getArticle().getId());
                        throw new InvalidEntityException("Aucun article avec l'ID " + ligCmdFrs .getArticle().getId() + " n'a été trouvé dans la base de données", ErrorCode.ARTICLE_NOT_FOUND);
                    }
                }
                else {
                    articleErrors.add("Impossibe d'enregistrer un commande avec un article Null "  );
                }
            });
        }


        // If there are article-related errors, log a warning and throw an InvalidEntityException
        if (!articleErrors.isEmpty()) {
            log.warn("Article is not exist {}", articleErrors);
            throw new InvalidEntityException("L'article n'est pas exist", ErrorCode.ARTICLE_NOT_FOUND, articleErrors);
        }

        // Save the CommandeClient entity to the database
        CommandeFournisseur savedCommandeClient = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));

        // Set the saved CommandeClient entity to each LigneCommandeClient in the DTO
        if (dto.getLigneCommandeFournisseurs()!= null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdFs -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdFs);
                ligneCommandeFournisseur.setCommandeFournisseur(savedCommandeClient);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });

        }

        // Convert the saved entity back to DTO and return
        return CommandeFournisseurDto.fromEntity(savedCommandeClient);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("Commande Fournisseur ID is null");
            return null;
        }

        Optional<CommandeFournisseur> commandeFournisseur = commandeFournisseurRepository.findById(id);

        return commandeFournisseur.map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucune Commande Fournisseur avec l'ID " + id + " n'a été trouvée", ErrorCode.COMMANDE_FOURNISSEUR_NOT_FOUND));
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
