package com.yassinecoding.gestiondestock.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UtilisateurDto {

    private String nom;
}
