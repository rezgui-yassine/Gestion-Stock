package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Article;
import com.yassinecoding.gestiondestock.model.CommandeFournisseur;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeFournisseurDto {

    private Article article;

    private CommandeFournisseur commandeFournisseur;
}
