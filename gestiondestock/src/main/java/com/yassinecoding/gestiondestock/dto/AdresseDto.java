package com.yassinecoding.gestiondestock.dto;


import com.yassinecoding.gestiondestock.model.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AdresseDto {

    private Integer id;

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostale;

    private String pays;

    // convertir un objet en DTO

    public static AdresseDto fromEntity (Adresse adresse){
        if (adresse == null){
            return  null;
            //TODO throw an exception if adresse is null
        }
        return AdresseDto.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .ville(adresse.getVille())
                .codePostale(adresse.getCodePostale())
                .pays(adresse.getPays())
                .build();

    }

    // convertir un DTO en objet
    public static Adresse toEntity(AdresseDto adresseDto){
        if (adresseDto == null){
            return  null;
            //TODO throw an exception if adresse is null
        }

        Adresse adresse = new Adresse();
        adresse.setAdresse1(adresseDto.getAdresse1());
        adresse.setAdresse2(adresseDto.getAdresse2());
        adresse.setVille(adresseDto.getVille());
        adresse.setCodePostale(adresseDto.getCodePostale());
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }



}
