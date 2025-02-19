package com.yassinecoding.gestiondestock.validator;

import com.yassinecoding.gestiondestock.dto.LigneCommandeFournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {
    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto) {
        List<String> errors = new ArrayList<>(); // Create a list of errors

        if (ligneCommandeFournisseurDto == null) {
            errors.add("Veuillez renseigner l'ID de la ligne commande fournisseur");
            errors.add("Veuillez renseigner le produit de la ligne commande fournisseur");
            errors.add("Veuillez renseigner la commande fournisseur de la ligne commande fournisseur");
            errors.add("Veuillez renseigner la quantité de la ligne commande fournisseur");
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande fournisseur");
            return errors;
        }

        if (ligneCommandeFournisseurDto.getId() == null) {
            errors.add("Veuillez renseigner l'ID de la ligne commande fournisseur");
        }

        if (ligneCommandeFournisseurDto.getArticle() == null) {
            errors.add("Veuillez renseigner le produit de la ligne commande fournisseur");
        }

        if (ligneCommandeFournisseurDto.getCommandeFournisseur() == null) {
            errors.add("Veuillez renseigner la commande fournisseur de la ligne commande fournisseur");
        }

        if (ligneCommandeFournisseurDto.getQuantite() == null) {
            errors.add("Veuillez renseigner la quantité de la ligne commande fournisseur");
        }

        if (ligneCommandeFournisseurDto.getPrixUnitaire() == null) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne commande fournisseur");
        }

        return errors;
    }
}