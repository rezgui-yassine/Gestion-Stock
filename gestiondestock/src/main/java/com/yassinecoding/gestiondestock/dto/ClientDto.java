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

    @JsonIgnore

    private List<CommandeClientDto> commandeClients;

//    public Client toEntity (Client client)
//    {
//        if (client == null)
//        {
//            return null;
//            //TODO throw an exception if client is null
//        }
//
//    }

}
