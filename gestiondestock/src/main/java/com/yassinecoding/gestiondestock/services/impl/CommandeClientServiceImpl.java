package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.CommandeClientDto;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Article;
import com.yassinecoding.gestiondestock.model.Client;
import com.yassinecoding.gestiondestock.repository.ArticleRepository;
import com.yassinecoding.gestiondestock.repository.ClientRepository;
import com.yassinecoding.gestiondestock.repository.CommandeClientRepository;
import com.yassinecoding.gestiondestock.services.CommandeClientService;
import com.yassinecoding.gestiondestock.validator.CommandeClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository , ClientRepository clientRepository, ArticleRepository articleRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
    }


    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        // if the client is not found, throw an exception
        if(!errors.isEmpty()){
            log.error("Commande Client is not valid {}", dto);
            throw new InvalidEntityException("La commande client n'est pas valide", ErrorCode.COMMANDE_CLIENT_NOT_VALID, errors);
        }
       //
        Optional<Client> clioent =clientRepository.findById(dto.getClient().getId());

        if(clioent.isEmpty()){
            log.warn("Client with ID {} was not found in the DB", dto.getClient().getId());
            throw new InvalidEntityException("Aucun client avec l'ID "+dto.getClient().getId()+" n'a été trouvé dans la base de données", ErrorCode.CLIENT_NOT_FOUND);
        }

        //
        List<String>articleErrors = new ArrayList<>();

      // verifie the ligneCommandeClient is not null and the article is not null
        if (dto.getLigneCommandeClients() != null){
            dto.getLigneCommandeClients().forEach(ligneCommandeClientDto -> {

                if(ligneCommandeClientDto.getArticle()!=null){
                    Optional<Article>article = articleRepository.findById(ligneCommandeClientDto.getArticle().getId());
                    if(article.isEmpty()){
                        log.warn("Article with ID {} was not found in the DB", ligneCommandeClientDto.getArticle().getId());
                        throw new InvalidEntityException("Aucun article avec l'ID "+ligneCommandeClientDto.getArticle().getId()+" n'a été trouvé dans la base de données", ErrorCode.ARTICLE_NOT_FOUND);
                    }

                }


            });

        }
        // test if the article is not null
        if (!articleErrors.isEmpty()){
            log.warn("Article is not exist {}", articleErrors);
            throw new InvalidEntityException("L'article n'est pas exist", ErrorCode.ARTICLE_NOT_VALID, articleErrors);
        }
        // save the commande client in the database

        return CommandeClientDto.fromEntity(
                commandeClientRepository.save(
                        CommandeClientDto.toEntity(dto)
                )
        );


    }

    @Override
    public CommandeClientDto findById(Integer id) {
        return null;
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return null;
    }



    @Override
    public List<CommandeClientDto> findAll() {
        return List.of();
    }

    @Override
    public CommandeClientDto delete(Integer id) {
        return null;
    }
}
