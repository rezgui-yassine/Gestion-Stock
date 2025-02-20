package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.ClientDto;
import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import com.yassinecoding.gestiondestock.model.Client;
import com.yassinecoding.gestiondestock.repository.ClientRepository;
import com.yassinecoding.gestiondestock.services.ClientService;
import com.yassinecoding.gestiondestock.validator.ClientValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;
import com.yassinecoding.gestiondestock.validator.ArticleValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientImpl implements ClientService {

    private static final Logger log = LoggerFactory.getLogger(ClientImpl.class);
    private final View error;
    private ClientRepository clientRepository;

    @Autowired
    public ClientImpl(ClientRepository clientRepository, View error) {
        this.clientRepository = clientRepository;
        this.error = error;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        // verification of the validity of the client
        List<String> errors = ClientValidator.validate(clientDto);
        if (!errors.isEmpty()) {
            log.error("Client is not valid: {}", errors);
            throw new InvalidEntityException("Client is not Found", ErrorCode.CLIENT_NOT_FOUND, errors);
        }
        return clientDto.fromEntity(
                clientRepository.save(ClientDto.toEntity(clientDto))
        );
    }

    @Override
    public ClientDto findById(Integer id) {
        // verification of the validity of the client
        if(id==null){
            log.error("Client ID is null");
            return null;
        }
        Optional < Client> clientOptional = clientRepository.findById(id);
        return  clientOptional
                .map(ClientDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "Aucun client avec l'ID = " + id + " n'a été trouvé dans la BDD",
                                ErrorCode.CLIENT_NOT_FOUND
                        )
                );

    }

    @Override
    public ClientDto findByNom(String nom) {
        if (nom.isEmpty()){
            log.error("Client Nom is null");
            return null;
        }
        Optional<Client> clientOptional = clientRepository.findClientByNom(nom);
        return clientOptional.map(ClientDto::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "Aucun client avec le nom = "+nom + " n'a été trouvé dans la BDD",
                                ErrorCode.CLIENT_NOT_FOUND
                        )
                );
    }

    @Override
    public List <ClientDto> findAll() {

        return clientRepository.findAll()
                .stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Client ID is null");
            return;
        }
        clientRepository.deleteById(id);

    }
}
