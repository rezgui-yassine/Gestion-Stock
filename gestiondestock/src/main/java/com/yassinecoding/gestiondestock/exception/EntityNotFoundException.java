package com.yassinecoding.gestiondestock.exception;

import jakarta.persistence.Entity;
import lombok.Getter;

public class EntityNotFoundException  extends RuntimeException {

    @Getter
    private ErrorCode errorCode;

    // constructor for the EntityNotFoundException : it takes a message and an error code

    public EntityNotFoundException (String message) {
        super(message);
    }

    // constructor for the EntityNotFoundException : it takes a message and cause of the error
    public EntityNotFoundException(String message ,Throwable cause) {
        super(message, cause);
    }

    // constructor for the EntityNotFoundException : it takes a message and an error code
    public EntityNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
