package com.proyectofinal.exceptions;

public class ResourceNotFoundException extends Exception
{
    public ResourceNotFoundException(String msj){
        super(msj);
    }
}