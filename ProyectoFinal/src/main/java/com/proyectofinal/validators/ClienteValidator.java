package com.proyectofinal.validators;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.model.ClienteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator
{
    public void validate(ClienteModel cliente) throws ResourceAlreadyExistsException {
        if(cliente == null)
            throw new ResourceAlreadyExistsException("Error: el cliente no puede ser nulo o vacío.");
    }
}
