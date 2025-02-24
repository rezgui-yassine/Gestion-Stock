package com.yassinecoding.gestiondestock.validator;

import com.yassinecoding.gestiondestock.dto.VentsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VentsValidator {

    private static final Logger log = LoggerFactory.getLogger(VentsValidator.class);

    public static List<String> validate (VentsDto ventsDto){
        List<String> errors = new ArrayList<>();

        if (ventsDto==null){
            errors.add("Veuillez renseigner le code de la vente");
            errors.add("Veuillez renseigner la date de la vente");
            errors.add("Veuillez renseigner l'identifiant de l'entreprise");
            return errors;
        }


        // checl if the id is not null or return error message
        if (ventsDto.getId() == null){
            errors.add("Veuillez renseigner l'identifiant de la vente");
            log.warn("Veuillez renseigner l'identifiant de la vente");
        }

        if (!StringUtils.hasLength(ventsDto.getCode())){
            errors.add("Veuillez renseigner le code de la vente");
            log.warn("Veuillez renseigner le code de la vente");
        }

        // check the date of vent is not null or return error message

        if(!StringUtils.hasLength(ventsDto.getDateVente().toString())){
            errors.add("Veuillez renseigner la date de la vente");
            log.warn("Veuillez renseigner la date de la vente");
        }

        if(!StringUtils.hasLength(ventsDto.getCommentaire())){
            errors.add("Veuillez renseigner le commentaire de la vente");
            log.warn("Veuillez renseigner le commentaire de la vente");
        }

//        if (ventsDto.getIdEntreprise()==null){
//            errors.add("Veuillez renseigner l'identifiant de l'entreprise");
//            log.warn("Veuillez renseigner l'identifiant de l'entreprise");
//        }

        return errors;
    }



}
