package com.yassinecoding.gestiondestock.exception;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException {
    @Getter
    private List<String> errors;

    @Getter
    private ErrorCode errorCode;

    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEntityException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidEntityException(String message, ErrorCode errorCode, List<String> errors) {
        super(message);
        this.errorCode = errorCode;
        this.errors = errors;
    }
}
