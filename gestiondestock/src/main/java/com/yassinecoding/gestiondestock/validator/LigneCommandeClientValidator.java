// LigneCommandeClientValidator.java
package com.yassinecoding.gestiondestock.validator;

import com.yassinecoding.gestiondestock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {

        List<String> errors = new ArrayList<>();

        if (ligneCommandeClientDto == null) {
            errors.add("Veuillez renseigner le produit de la ligne commande client");
            errors.add("Veuillez renseigner la quantité de la ligne commande client");
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande client");
            return errors;
        }

        if (ligneCommandeClientDto.getCommandeClient() == null) {
            errors.add("Veuillez renseigner la commande client de la ligne commande client");
        } else {
            if (!StringUtils.hasLength(ligneCommandeClientDto.getCommandeClient().getCode())) {
                errors.add("Veuillez renseigner le code de la commande client");
            }
        }

        if (ligneCommandeClientDto.getArticle() == null) {
            errors.add("Veuillez renseigner le produit de la ligne commande client");
        }

        if (ligneCommandeClientDto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité de la ligne commande client");
        }

        if (ligneCommandeClientDto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande client");
        }

        return errors;
    }
}