package com.proyectofinal.controller;

import com.proyectofinal.exceptions.ResourceNotFoundException;
import com.proyectofinal.model.DetalleVentaModel;
import com.proyectofinal.service.DetalleVentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/detalle")
public class DetalleVentaController
{
    @Autowired
    private DetalleVentaServiceImpl detalleSvc;

    @GetMapping(value = "/getDetalleVentaById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getDetalleById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(detalleSvc.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/getDetalleVentaByVtaId/{ventaId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DetalleVentaModel>> getDetallesByVtaId(@PathVariable(name = "ventaId") Long ventaId) throws ResourceNotFoundException {
        return new ResponseEntity<>(detalleSvc.findDetallesByVtaId(ventaId), HttpStatus.OK);
    }

    @GetMapping(value = "/todos")
    public ResponseEntity<List<DetalleVentaModel>> findAllDetalles() throws ResourceNotFoundException {
        return new ResponseEntity<>(detalleSvc.findAll(), HttpStatus.OK);
    }
}
