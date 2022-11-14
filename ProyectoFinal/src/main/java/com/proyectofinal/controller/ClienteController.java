package com.proyectofinal.controller;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController
{
    @Autowired
    private ClienteServiceImpl clienteSvc;

    @GetMapping(value = "/getClienteById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClienteById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException
    {
      return new ResponseEntity<>(clienteSvc.findClienteById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getClienteByDNI/{dni}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClienteById(@PathVariable(name = "dni") String dni) throws ResourceNotFoundException {
        return new ResponseEntity<>(clienteSvc.findClienteByDNI(dni), HttpStatus.OK);
    }

    @GetMapping(value = "/getTodos")
    public ResponseEntity<List<ClienteModel>> findAllClientes() throws ResourceNotFoundException {
        return new ResponseEntity<>(clienteSvc.findClientes(), HttpStatus.OK);
    }

    @PostMapping(value = "/postNewCliente")
    public ResponseEntity<String> createCliente(@RequestBody ClienteModel newCli) throws ResourceNotFoundException, ResourceAlreadyExistsException {
        return new ResponseEntity<>(clienteSvc.createCliente(newCli), HttpStatus.OK);
    }

    @PutMapping(value = "/updateCliente/{id}")
    public ResponseEntity<String> updateCliente(@RequestBody ClienteModel cliente, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(clienteSvc.updateCliente(cliente, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException, ResourceAlreadyExistsException {
        String rtado = clienteSvc.deleteById(id);
        if(rtado.equals("ok"))
            return new ResponseEntity<>("Cliente de id " + id + " eliminado.", HttpStatus.OK);
        else
            return new ResponseEntity<>("Error al eliminar cliente de id " + id + ".", HttpStatus.BAD_REQUEST);
    }
}
