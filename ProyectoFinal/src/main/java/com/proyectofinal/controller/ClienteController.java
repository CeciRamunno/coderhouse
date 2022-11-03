package com.proyectofinal.controller;

import com.proyectofinal.exceptions.ResourceAlreadyExistsException;
import com.proyectofinal.model.ClienteModel;
import com.proyectofinal.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(path = "api/cliente")
@RestController
public class ClienteController
{
    @Autowired
    private ClienteServiceImpl clienteSvc;

    @GetMapping("/{id}")
    public Optional<ClienteModel> findById(int id)
    {
        return clienteSvc.findById(id);
    }

//    @GetMapping("/getTodos")
//    public ResponseEntity<List<ClienteModel>> findAll()
//    {
//        return new ResponseEntity<>(this.clienteSvc.findAll(), HttpStatus.OK);
//    }

//    @PostMapping("/postAltaCliente")
//    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel nuevoCliente) throws ResourceAlreadyExistsException {
//        return new ResponseEntity<>(this.clienteSvc.create(nuevoCliente), HttpStatus.OK);
//    }
//
//    @PostMapping("/postUpdateCliente")
//    public ResponseEntity<ClienteModel> updateCliente(@RequestBody ClienteModel clienteModif, @PathVariable int id)
//    {
//        return new ResponseEntity<>(clienteSvc.update(clienteModif, id), HttpStatus.OK);
//    }

}
