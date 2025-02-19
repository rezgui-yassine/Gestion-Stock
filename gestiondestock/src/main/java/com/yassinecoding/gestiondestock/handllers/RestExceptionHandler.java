package com.yassinecoding.gestiondestock.handllers;

import com.yassinecoding.gestiondestock.exception.EntityNotFoundException;
import com.yassinecoding.gestiondestock.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


// cette annotation permet de dire à spring que cette classe est un gestionnaire d'exception
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    // Cette méthode gère les exceptions de type EntityNotFoundException et renvoie une réponse HTTP avec un statut 404 et un objet ErrorDto.
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleException(EntityNotFoundException exception, WebRequest webRequest) {
        {
            final HttpStatus notFound = HttpStatus.NOT_FOUND;
            final ErrorDto errorDto = ErrorDto.builder()
                    .code(exception.getErrorCode())
                    .httpCode(notFound.value())
                    .message(exception.getMessage())
                    .build();
            return new ResponseEntity(errorDto, notFound);
        }

    }
    // Cette méthode gère les exceptions de type InvalidEntityException et renvoie une réponse HTTP avec un statut 400 et un objet ErrorDto.
    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception , WebRequest webRequest ){
        {
            final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
            final ErrorDto errorDto = ErrorDto.builder()
                    .code(exception.getErrorCode())
                    .httpCode(badRequest.value())
                    .message(exception.getMessage())
                    .errors(exception.getErrors())
                    .build();
            return new ResponseEntity(errorDto, badRequest);
        }
    }
}