package com.clienteapirest.service;

import com.clienteapirest.model.ClienteModel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class ClienteService
{
    public String getEdadCliente(ClienteModel cliente)
    {
        long edad = ChronoUnit.YEARS.between(cliente.getFechaNacimiento(), LocalDate.now());

        return "Nuestro cliente " + cliente.getNombre() + " " + cliente.getApellido() + " tiene " + edad + " años.";
    }
}
