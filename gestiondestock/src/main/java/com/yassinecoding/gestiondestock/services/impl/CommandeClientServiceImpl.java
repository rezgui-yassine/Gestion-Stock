package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.CommandeClientDto;
import com.yassinecoding.gestiondestock.dto.LigneCommandeClientDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Article;
import com.yassinecoding.gestiondestock.model.Client;
import com.yassinecoding.gestiondestock.model.CommandeClient;
import com.yassinecoding.gestiondestock.model.LigneCommandeClient;
import com.yassinecoding.gestiondestock.repository.ArticleRepository;
import com.yassinecoding.gestiondestock.repository.ClientRepository;
import com.yassinecoding.gestiondestock.repository.CommandeClientRepository;
import com.yassinecoding.gestiondestock.repository.LigneCommandeClientRepository;
import com.yassinecoding.gestiondestock.services.CommandeClientService;
import com.yassinecoding.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j

public class CommandeClientServiceImpl implements CommandeClientService {

    private final LigneCommandeClientRepository ligneCommandeClientRepository;
    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository , ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }


    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        // Validate the CommandeClientDto object and collect any validation errors
        List<String> errors = CommandeClientValidator.validate(dto);

        // If there are validation errors, log the error and throw an InvalidEntityException
        if (!errors.isEmpty()) {
            log.error("Commande Client is not valid {}", dto);
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID, errors);
        }

        // Retrieve the client from the repository using the client ID from the DTO
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());

        // If the client is not found, log a warning and throw an InvalidEntityException
        if (client.isEmpty()) {
            log.warn("Client with ID {} was not found in the DB", dto.getClient().getId());
            throw new InvalidEntityException("Aucun client avec l'ID " + dto.getClient().getId() + " n'a été trouvé dans la base de données", ErrorCode.CLIENT_NOT_FOUND);
        }

        // Initialize a list to collect any article-related errors
        List<String> articleErrors = new ArrayList<>();

        // Verify that the ligneCommandeClients list is not null and that each article in the list is valid
        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligneCommandeClientDto -> {
                if (ligneCommandeClientDto.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligneCommandeClientDto.getArticle().getId());
                    if (article.isEmpty()) {
                        log.warn("Article with ID {} was not found in the DB", ligneCommandeClientDto.getArticle().getId());
                        throw new InvalidEntityException("Aucun article avec l'ID " + ligneCommandeClientDto.getArticle().getId() + " n'a été trouvé dans la base de données", ErrorCode.ARTICLE_NOT_FOUND);
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
        CommandeClient savedCommandeClient = commandeClientRepository.save(CommandeClientDto.toEntity(dto));

        // Set the saved CommandeClient entity to each LigneCommandeClient in the DTO
        if (dto.getLigneCommandeClients()!= null) {
            dto.getLigneCommandeClients().forEach(ligneCommandeClientDto -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligneCommandeClientDto);
                ligneCommandeClient.setCommandeClient(savedCommandeClient);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });

        }
        return CommandeClientDto.fromEntity(savedCommandeClient);    
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if(id == null){
            log.error("Commande Client ID is null");
            return null;
        }
        Optional<CommandeClient>commandeClient=commandeClientRepository.findById(id);
        return commandeClient.map(CommandeClientDto::fromEntity)
                .orElseThrow( ()-> new EntityNotFoundException("Acune Commande Client ave L'ID"+id,ErrorCode.COMMANDE_CLIENT_NOT_FOUND));

    }

    @Override
    public CommandeClientDto findByCode(String code) {

        if (!StringUtils.hasLength(code)) {
            log.error("Commande Client Code is null");
            return null;
        }

        Optional<CommandeClient> commandeClient = commandeClientRepository.findCommandeClientByCode(code);


        return commandeClient.map(CommandeClientDto::fromEntity)
                .orElseThrow(
                        () -> new EntityNotFoundException("Acune Commande Client avec le Code " + code, ErrorCode.COMMANDE_CLIENT_NOT_FOUND)
                )
                ;
    }



    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll()
                .stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Commande Client ID is null");
            return;
        }
      commandeClientRepository.deleteById(id);
    }
}
