package com.yassinecoding.gestiondestock.validator;

import com.yassinecoding.gestiondestock.dto.MovementStockDto;

import java.util.ArrayList;
import java.util.List;

public class MovementStockValidator {
    public static List<String> validate(MovementStockDto movementStockDto){
        List<String> errors = new ArrayList<>();

        if (movementStockDto == null){
            errors.add("Veuillez renseigner la date du mouvement");
            errors.add("Veuillez renseigner la quantité du mouvement");
            errors.add("Veuillez renseigner l'article du mouvement");
            errors.add("Veuillez renseigner le type du mouvement");
            return errors;
        }

        if (movementStockDto.getDateMvt() == null){
            errors.add("Veuillez renseigner la date du mouvement");
        }
        if(movementStockDto.getQuantite() == null){
            errors.add("Veuillez renseigner la quantité du mouvement");
        }
        if(movementStockDto.getArticle() == null){
            errors.add("Veuillez renseigner l'article du mouvement");
        }
        if (movementStockDto.getTypeMvt()==null){
            errors.add("Veuillez renseigner le type du mouvement");
        }

        return  errors;
    }
}
