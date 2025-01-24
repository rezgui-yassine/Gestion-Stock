package com.yassinecoding.gestiondestock.validator;


import com.yassinecoding.gestiondestock.dto.UtilisateurDto;
import com.yassinecoding.gestiondestock.model.Utilisateur;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidateur {

    public static List<String> validate(UtilisateurDto utilisateurDto) {

        List<String> errors = new ArrayList<>();
        // Check if the user name is empty or return error message
        if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getNom()) ) {
            errors.add("Veuillez renseigner le nom de l'utilisateur");
        }
        // Check if the user first name is empty or return error message
        if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getPrenom()) ) {
            errors.add("Veuillez renseigner le prenom de l'utilisateur");
        }
        // Check if the user email is empty or return error message
        if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getEmail()) ) {
            errors.add("Veuillez renseigner l'email de l'utilisateur");
        }
        // Check if the user date of birth is empty or return error message
        if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getDateDeNaissance().toString()) ) {
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur");
        }
        // Check if the user password is empty or return error message
        if(utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
        }
        // Check if the user address is empty or return error message
        if(utilisateurDto == null ){
            errors.add("Veuillez renseigner l'adresse de l'utilisateur");
        }else {
            // Check if the user photo is empty or return error message
            if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse2())) {
                errors.add("Le champ adresse 1 est obligatoire");
            }
            if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getAdresse().getVille())) {
                errors.add("Le champ adresse 2 est obligatoire");
            }
            if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
                errors.add("Le champ ville  est obligatoire");
            }
            if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())) {
                errors.add("Le champ Code Postal   est obligatoire");
            }
            if (utilisateurDto == null || StringUtils.hasLength(utilisateurDto.getAdresse().getPays())) {
                errors.add("Le champPays   est obligatoire");
            }


        }


        return errors;
    }
}
