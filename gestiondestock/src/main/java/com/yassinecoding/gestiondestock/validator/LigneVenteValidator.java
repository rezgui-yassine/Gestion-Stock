package com.yassinecoding.gestiondestock.validator;

import com.yassinecoding.gestiondestock.dto.LigneVenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {
    public static List<String> validate (LigneVenteDto ligneVenteDto) {
        List<String> errors  = new ArrayList<>();

        if(ligneVenteDto == null) {
            errors.add("Veuillez renseigner l'ID de la ligne vente");
            errors.add("Veuillez renseigner la vente de la ligne vente");
            errors.add("Veuillez renseigner la quantité de la ligne vente");
            errors.add("Veuillez renseigner le prix unitaire de la ligne vente");
            return errors;
        }

        if (ligneVenteDto.getId() == null) {
            errors.add("Veuillez renseigner l ' ID  de l'article");
        }
        if(ligneVenteDto.getVente() == null) {
            errors.add("Veuillez renseigner la vente de la ligne vente");
        }
        if (ligneVenteDto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité de la ligne vente");
        }
        if(ligneVenteDto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne vente");
        }


        return  errors;
    }
}
