package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Adresse;
import com.yassinecoding.gestiondestock.model.CommandeClient;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ClientDto {


    private String nom;
    private String prenom;

    private Adresse adresse;

    private String photo;

    private String mail;

    private String numTel;


    private List<CommandeClient> commandeClients;
}
