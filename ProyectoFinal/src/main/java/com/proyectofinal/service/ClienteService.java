package com.proyectofinal.service;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.repository.ClienteRepository;
import com.proyectofinal.validators.ClienteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteValidator clienteValidator;

    public Optional<ClienteModel> findById(int id)
    {
        return this.clienteRepository.findById(id);
    }

    public List<ClienteModel> findAll()
    {
        return this.clienteRepository.findAll();
    }

    public ClienteModel create(ClienteModel newClient) throws ResourceAlreadyExistsException {
        this.clienteValidator.validate(newClient);
        return this.clienteRepository.save(newClient);
    }

    public ClienteModel update(ClienteModel cliente, int id)
    {
        Optional<ClienteModel> clienteBD = this.clienteRepository.findById(id);
        if(clienteBD.isPresent())
        {
            ClienteModel clienteABM = clienteBD.get();

            clienteABM.setDni(cliente.getDni());
            clienteABM.setNombre(cliente.getNombre());
            clienteABM.setApellido(cliente.getApellido());
            clienteABM.setFechaNacimiento(cliente.getFechaNacimiento());

            return this.clienteRepository.save(clienteABM);
        }
        return null;
    }

    public void deleteById(int id)
    {
        this.clienteRepository.deleteById(id);
    }

}
