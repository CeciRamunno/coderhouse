package com.proyectofinal.controller;

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
public class ClienteController {
    @Autowired
    private ClienteServiceImpl clienteSvc;

    @GetMapping(value = "/getClienteById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClienteById(@PathVariable(name = "id") Long id)
    {
        return new ResponseEntity<>(clienteSvc.findClienteById(id), HttpStatus.OK);
    }
    @GetMapping(value = "/getTodos")
    public ResponseEntity<List<ClienteModel>> findAllClientes()
    {
        return new ResponseEntity<>(clienteSvc.findClientes(), HttpStatus.OK);
    }

    @PostMapping(value = "/postNewCliente")
    public ResponseEntity<ClienteModel> createCliente(@RequestBody ClienteModel newCli)
    {
        return new ResponseEntity<>(clienteSvc.createCliente(newCli), HttpStatus.OK);
    }

    @PutMapping(value = "/updateCliente/{id}")
    public ResponseEntity<ClienteModel> updateCliente(@RequestBody ClienteModel cliente, @PathVariable Long id)
    {
        return new ResponseEntity<>(clienteSvc.updateCliente(cliente, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id)
    {
        clienteSvc.deleteById(id);
        return new ResponseEntity<>("Cliente de id " + id + " eliminado.", HttpStatus.OK);
    }
}
