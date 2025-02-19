package com.yassinecoding.gestiondestock.exception;

public enum ErrorCode {

    // we use the enum to define the error code
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    // TODO complete the rest  of error code
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),
    ENTREPRISE_NOT_FOUND(6000),
    FOURNISSEUR_NOT_FOUND(7000),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_FOURNISSEUR_NOT_FOUND(9000),
    LIGNE_VENTE_NOT_FOUND(10000),
    MVVT_STK_NOT_FOUND(11000),
    UTILISATEUR_NOT_FOUND(12000),
    VENTES_NOT_FOUND(13000),
    BAD_REQUEST(14000),
    INVALID_FIELD(15000),
    INVALID_TYPE(16000),;

    private final Integer code;

    // constructor for the enum ErrorCode

    ErrorCode(Integer code) {
        this.code = code;
    }

    // renvoyer le code de l'erreur

    public Integer getCode() {
        return code;
    }
}
