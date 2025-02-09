package com.yassinecoding.gestiondestock.validator;

import com.yassinecoding.gestiondestock.dto.LigneCommandeClientDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto) {

        List<String> errors = new ArrayList<>(); // Create a list of errors

        if (ligneCommandeClientDto == null) {
            errors.add("Veuillez renseigner le produit de la ligne commande client");
            errors.add("Veuillez renseigner la quantité de la ligne commande client");
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande client");
            return errors;
        }

        if (ligneCommandeClientDto.getCommandeClient() == null) {
            errors.add("Veuillez renseigner la commande client de la ligne commande client");
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