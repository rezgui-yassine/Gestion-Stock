package com.yassinecoding.gestiondestock.services.impl;

import com.yassinecoding.gestiondestock.dto.ClientDto;
import com.yassinecoding.gestiondestock.exception.ErrorCode;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
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
        return null;
    }

    @Override
    public ClientDto findByNom(String nom) {
        return null;
    }

    @Override
    public ClientDto findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
