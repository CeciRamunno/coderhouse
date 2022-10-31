package com.proyectofinal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException
{
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Error> resourceAlreadyExistsException(Exception e)
    {
        Error error = new Error();

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
