package com.yassinecoding.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yassinecoding.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto {

    private Integer id;
    private String nom;
    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    private Integer idEntreprise;

    @JsonIgnore

    private List<CommandeClientDto> commandeClients;

    // creat a method to convert an object to DTO

    public static ClientDto fromEntity(Client client){
        if (client == null){
            return null;
            // TODO throw an exception if client is null

        }
        // convert an object to DTO
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(AdresseDto.fromEntity(client.getAdresse()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();

    }

    // creat a method to convert a DTO to an object
    public static Client toEntity (ClientDto clientDto){
        if (clientDto == null){
            return null;
            // TODO throw an exception if clientDto is null
        }
        // convert a DTO to an object
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setAdresse(AdresseDto.toEntity(clientDto.getAdresse()));
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumTel(clientDto.getNumTel());
        return client;
    }

}
