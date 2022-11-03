package com.proyectofinal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Error> resourceAlreadyExistsException(Exception ex)
    {
        Error error = new Error();
//        error.setMsg(ex.getMessage());
//        error.setStatus("ERROR");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> illegalArgumentException(Exception ex)
    {
        Error error = new Error();
//        error.setMsg(ex.getMessage());
//        error.setStatus("ERROR");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> resourceNotFoundException(Exception ex)
    {
        Error error = new Error();
//        error.setMsg(ex.getMessage());
//        error.setStatus("ERROR");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
