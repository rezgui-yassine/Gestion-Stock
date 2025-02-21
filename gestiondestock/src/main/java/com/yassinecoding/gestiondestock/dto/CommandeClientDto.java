package com.yassinecoding.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yassinecoding.gestiondestock.model.Client;
import com.yassinecoding.gestiondestock.model.CommandeClient;
import com.yassinecoding.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class CommandeClientDto {

    private Integer id;
    private String code;
    private Instant dateCommande;
    private ClientDto client;
    @JsonIgnore

    private List<LigneCommandeClientDto> ligneCommandeClients;

    // Create a method to convert an object to DTO
    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
            // TODO throw an exception if client is null
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .ligneCommandeClients(commandeClient.getLigneCommandeClients() != null ?
                        commandeClient.getLigneCommandeClients().stream()
                                .map(LigneCommandeClientDto::fromEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    // Create a method to convert a DTO to an object
    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
            // TODO throw an exception if clientDto is null
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));
        commandeClient.setLigneCommandeClients(commandeClientDto.getLigneCommandeClients() != null ?
                commandeClientDto.getLigneCommandeClients().stream()
                        .map(LigneCommandeClientDto::toEntity)
                        .collect(Collectors.toList()) : null);
        return commandeClient;
    }
}