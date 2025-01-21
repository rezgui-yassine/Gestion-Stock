package com.yassinecoding.gestiondestock.dto;


import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class VentsDto {
    private Integer id;
    private String code;

    private Instant dateVente;

    private String commentaire;
}
