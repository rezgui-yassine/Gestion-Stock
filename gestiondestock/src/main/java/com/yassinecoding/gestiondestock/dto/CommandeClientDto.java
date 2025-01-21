package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Client;
import com.yassinecoding.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;


import java.time.Instant;
import java.util.List;

@Builder
@Data
public class CommandeClientDto {


    private String Code;



    private Instant dateCommande;



    private Client client;

    private List<LigneCommandeClient> ligneCommandeClients;
}
