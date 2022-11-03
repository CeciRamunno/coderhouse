package com.proyectofinal.service;

import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.repository.ClienteRepository;
import com.proyectofinal.validators.ClienteValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface ClienteService
{
    public Optional<ClienteModel> findById(int id);
}
