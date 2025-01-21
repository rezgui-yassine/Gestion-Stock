package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Article;
import com.yassinecoding.gestiondestock.model.CommandeClient;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeClientDto {


    private Article article;

    private CommandeClient commandeClient;
}
