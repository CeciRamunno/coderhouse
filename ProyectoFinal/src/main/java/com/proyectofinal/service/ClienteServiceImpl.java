package com.proyectofinal.service;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.model.VentaModel;
import com.proyectofinal.repository.ClienteRepository;
import com.proyectofinal.repository.VentaRepository;
import com.proyectofinal.validators.ClienteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService
{
    @Autowired
    private ClienteRepository cliRepository;

    @Autowired
    private ClienteValidator cliValidator;

    @Autowired
    private VentaRepository vtaRepository;

    @Override
    public Optional<ClienteModel> findClienteById(Long id) throws ResourceNotFoundException
    {
        this.cliValidator.validateId(id);

        Optional<ClienteModel> cliente = this.cliRepository.findById(id);
        if(cliente.isPresent())
            return cliente;
        else
            throw new ResourceNotFoundException("No existe cliente para el ID " + id + "." );
    }

    @Override
    public ClienteModel findClienteByDNI(String dni) throws ResourceNotFoundException {
        ClienteModel cliente = this.cliRepository.findClienteByDNI(dni);
        this.cliValidator.validateByDNI(cliente);

        return cliente;
    }

    @Override
    public List<ClienteModel> findClientes() throws ResourceNotFoundException {
        List<ClienteModel> clientes = this.cliRepository.findAll();
        this.cliValidator.validateLista(clientes);

        return clientes;
    }

    @Override
    public String createCliente(ClienteModel newCliente) throws ResourceAlreadyExistsException
    {
        // Valido que el nuevo cliente informado no sea null ni que sus campos a completar lo sean.
        cliValidator.validate(newCliente);

        // Valido que no exista en la BD:
        Boolean existe = this.cliRepository.findClienteByDNI(newCliente.getDni()) == null ? false : true;
        if(existe)
            throw new ResourceAlreadyExistsException("El cliente que quiere ingresar ya existe en la Base de Datos.");

        cliRepository.save(newCliente);
        return newCliente.informeNewCliente();
    }

    @Override
    public String updateCliente(ClienteModel cliente, Long id) throws ResourceNotFoundException
    {
        // Valido que no sea null. Que tenga sus campos obligatorios completos.
        cliValidator.validate(cliente);

        // Valido que el cliente a actualizar esté en la Base de datos.
        Optional<ClienteModel> clienteDB = this.cliRepository.findById(id);

        if(clienteDB.isPresent())
        {
            ClienteModel clienteABM = clienteDB.get();

            clienteABM.setDni(cliente.getDni());
            clienteABM.setNombre(cliente.getNombre());
            clienteABM.setApellido(cliente.getApellido());
            clienteABM.setFechaNacimiento(cliente.getFechaNacimiento());

            this.cliRepository.save(clienteABM);
            return clienteABM.informeCliActualizado();
        }
        else
            throw new ResourceNotFoundException("El cliente que desea actualizar no se encuentra en la Base de Datos.");
    }

    @Override
    public String deleteById(Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException
    {
        if(id == null)
            throw new IllegalArgumentException("No se ingresó ID de cliente a eliminar.");

        // Valido si el cliente existe en la Base de Datos.
        Optional<ClienteModel> cliente = this.cliRepository.findById(id);

        if(!cliente.isPresent())
            throw new ResourceNotFoundException("No se encontró el cliente a eliminar en la Base de Datos.");

        // Valido que no exista en otras tablas de la Base de Datos.
        List<VentaModel> lstVtasByClienteId = vtaRepository.findVentasByClienteId(id);
        if(!lstVtasByClienteId.isEmpty() || lstVtasByClienteId.size() > 0)
            throw new ResourceAlreadyExistsException("El cliente no puede eliminarse, puesto que existe en otras tablas.");

        this.cliRepository.deleteById(id);
        return "ok";
    }
}
