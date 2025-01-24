package com.yassinecoding.gestiondestock.dto;

import com.yassinecoding.gestiondestock.model.Entreprise;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class EntrepriseDto {
    private Integer id;
    private String nom;
    private String description;
    private AdresseDto adresse;
    private String codeFiscal;
    private String photo;
    private String email;
    private String numTel;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurs;

    // Create a method to convert an object to DTO
    public static EntrepriseDto fromEntity(Entreprise entreprise) {
        if (entreprise == null) {
            return null;
            // TODO throw an exception if entreprise is null
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .email(entreprise.getEmail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .utilisateurs(entreprise.getUtilisateurs() != null ?
                        entreprise.getUtilisateurs().stream()
                                .map(UtilisateurDto::fromEntity)
                                .collect(Collectors.toList()) : null)
                .build();
    }

    // Create a method to convert a DTO to an object
    public static Entreprise toEntity(EntrepriseDto entrepriseDto) {
        if (entrepriseDto == null) {
            return null;
            // TODO throw an exception if entrepriseDto is null
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        entreprise.setUtilisateurs(entrepriseDto.getUtilisateurs() != null ?
                entrepriseDto.getUtilisateurs().stream()
                        .map(UtilisateurDto::toEntity)
                        .collect(Collectors.toList()) : null);
        return entreprise;
    }
}