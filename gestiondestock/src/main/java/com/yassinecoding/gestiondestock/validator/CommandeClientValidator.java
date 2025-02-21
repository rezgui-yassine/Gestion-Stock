// CommandeClientValidator.java
package com.yassinecoding.gestiondestock.validator;

import com.yassinecoding.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto commandeClientDto) {
        List<String> errors = new ArrayList<>();

        if (commandeClientDto == null) {
            errors.add("Veuillez renseigner le code de la commande client");
            errors.add("Veuillez renseigner la date de la commande client");
            errors.add("Veuillez renseigner le client de la commande client");
            return errors;
        }

        if (!StringUtils.hasLength(commandeClientDto.getCode())) {
            errors.add("Veuillez renseigner le code de la commande client");
        }

        if (commandeClientDto.getDateCommande() == null) {
            errors.add("Veuillez renseigner la date de la commande client");
        }

        if (commandeClientDto.getClient() == null) {
            errors.add("Veuillez renseigner le client de la commande client");
        }

        return errors;
    }
}